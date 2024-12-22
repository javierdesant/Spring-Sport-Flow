package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
import com.javierdesant.spring_sport_flow.api.dto.responses.CategoryResponse;
import com.javierdesant.spring_sport_flow.api.dto.responses.LeagueResponse;
import com.javierdesant.spring_sport_flow.api.dto.responses.SportResponse;
import com.javierdesant.spring_sport_flow.api.dto.responses.TournamentResponse;
import com.javierdesant.spring_sport_flow.domain.entities.CategoryEntity;
import com.javierdesant.spring_sport_flow.domain.entities.LeagueEntity;
import com.javierdesant.spring_sport_flow.domain.entities.SportEntity;
import com.javierdesant.spring_sport_flow.domain.entities.TournamentEntity;
import com.javierdesant.spring_sport_flow.domain.repositories.CategoryRepository;
import com.javierdesant.spring_sport_flow.domain.repositories.LeagueRepository;
import com.javierdesant.spring_sport_flow.domain.repositories.SportRepository;
import com.javierdesant.spring_sport_flow.domain.repositories.TournamentRepository;
import com.javierdesant.spring_sport_flow.infrastructure.services.contracts.ITournamentService;
import com.javierdesant.spring_sport_flow.utils.TimeFrame;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class TournamentService implements ITournamentService {
    private final TournamentRepository tournamentRepository;
    private final LeagueRepository leagueRepository;
    private final SportRepository sportRepository;
    private final CategoryRepository categoryRepository;

    private static TournamentResponse toResponse(TournamentEntity entity) {
        TournamentResponse response = new TournamentResponse();
        BeanUtils.copyProperties(entity, response);

        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(entity.getCategory(), categoryResponse);
        SportResponse sportResponse = new SportResponse();
        BeanUtils.copyProperties(entity.getSport(), sportResponse);
        LeagueResponse leagueResponse = new LeagueResponse();
        BeanUtils.copyProperties(entity.getLeague(), leagueResponse);

        response = response.toBuilder()
                .category(categoryResponse)
                .sport(sportResponse)
                .league(leagueResponse)
                .build();

        return response;
    }

    @Override
    public TournamentResponse create(TournamentRequest request) {
        LeagueEntity leagueEntity = getLeagueById(request.getLeagueCode());
        SportEntity sportEntity = getSportById(request.getSportCode());
        CategoryEntity categoryEntity = getCategoryById(request.getCategoryCode());

        TimeFrame tournamentTimeFrame = new TimeFrame(request.getStartDate(), request.getEndDate());

        TournamentEntity tournamentEntity = TournamentEntity.builder().tournamentName(request.getTournamentName()).league(leagueEntity).sport(sportEntity).category(categoryEntity).timeFrame(tournamentTimeFrame).build();

        TournamentEntity savedTournament = tournamentRepository.save(tournamentEntity);
        log.info("Tournament '{} (ID: {})' saved successfully.", savedTournament.getTournamentName(), savedTournament.getTournamentId());

        return toResponse(savedTournament);
    }

    private LeagueEntity getLeagueById(String leagueCode) {
        return leagueRepository.findById(leagueCode)
                .orElseThrow(EntityNotFoundException::new);
    }

    private SportEntity getSportById(String sportCode) {
        return sportRepository.findById(sportCode)
                .orElseThrow(EntityNotFoundException::new);
    }

    private CategoryEntity getCategoryById(String categoryCode) {
        return categoryRepository.findById(categoryCode)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public TournamentResponse read(Long aLong) {
        return tournamentRepository.findById(aLong)
                .map(TournamentService::toResponse)
                .orElseThrow(EntityNotFoundException::new);
    }

    // TODO: revisar metodo:
    @Override
    public TournamentResponse update(TournamentRequest request, Long aLong) {
        TournamentEntity tournament = tournamentRepository.findById(aLong).orElseThrow(EntityNotFoundException::new);

        LeagueEntity league = leagueRepository.findById(request.getLeagueCode())
                .orElseThrow(EntityNotFoundException::new);
        SportEntity sport = sportRepository.findById(request.getSportCode())
                .orElseThrow(EntityNotFoundException::new);
        CategoryEntity category = categoryRepository.findById(request.getCategoryCode())
                .orElseThrow(EntityNotFoundException::new);

        TimeFrame timeFrame = new TimeFrame(request.getStartDate(), request.getEndDate());

        // TODO: improve this
        tournament = tournament.toBuilder()
                .tournamentName(request.getTournamentName())
                .league(league).sport(sport)
                .category(category)
                .timeFrame(timeFrame)
                .build();

        tournament = tournamentRepository.save(tournament);

        log.info("Tournament updated with id: {}", tournament.getTournamentId());

        return toResponse(tournament);
    }

    @Override
    public void delete(Long aLong) {
        tournamentRepository.deleteById(aLong);
    }

    @Override
    public Page<TournamentResponse> listAll(Pageable pageable) {
        return tournamentRepository.findAll(pageable)
                .map(TournamentService::toResponse);
    }
}
