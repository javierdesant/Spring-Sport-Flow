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
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Override
    public TournamentResponse create(TournamentRequest request) {
        LeagueEntity leagueEntity = findLeagueById(request.getLeagueCode());
        SportEntity sportEntity = findSportById(request.getSportCode());
        CategoryEntity categoryEntity = findCategoryById(request.getCategoryCode());

        TimeFrame tournamentTimeFrame = new TimeFrame(request.getStartDate(), request.getEndDate());

        TournamentEntity tournamentEntity = TournamentEntity.builder()
                .tournamentName(request.getTournamentName())
                .league(leagueEntity)
                .sport(sportEntity)
                .category(categoryEntity)
                .timeFrame(tournamentTimeFrame)
                .build();

        TournamentEntity savedTournament = tournamentRepository.save(tournamentEntity);
        log.info("Tournament '{} (ID: {})' saved successfully.", savedTournament.getTournamentName(), savedTournament.getTournamentId());

        return toResponse(savedTournament);
    }

    private LeagueEntity findLeagueById(String leagueCode) {
        return leagueRepository.findById(leagueCode)
                .orElseThrow();
    }

    private SportEntity findSportById(String sportCode) {
        return sportRepository.findById(sportCode)
                .orElseThrow();
    }

    private CategoryEntity findCategoryById(String categoryCode) {
        return categoryRepository.findById(categoryCode)
                .orElseThrow();
    }

    @Override
    public TournamentResponse read(Long aLong) {
        return tournamentRepository.findById(aLong)
                .map(TournamentService::toResponse)
                .orElseThrow();
    }

    @Override
    public TournamentResponse update(TournamentRequest request, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {
        tournamentRepository.deleteById(aLong);
    }

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
}
