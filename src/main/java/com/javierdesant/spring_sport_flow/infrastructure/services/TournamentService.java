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
        LeagueEntity league = leagueRepository.findById(request.getLeagueCode()).orElseThrow();
        SportEntity sport = sportRepository.findById(request.getSportCode()).orElseThrow();
        CategoryEntity category = categoryRepository.findById(request.getCategoryCode()).orElseThrow();

        TimeFrame timeFrame = new TimeFrame(request.getStartDate(), request.getEndDate());

        TournamentEntity tournamentEntity = TournamentEntity.builder()
                .name(request.getName())
                .league(league)
                .sport(sport)
                .category(category)
                .timeFrame(timeFrame)
                .build();

        tournamentEntity = tournamentRepository.save(tournamentEntity);

        log.info("Tournament saved with id: {}", tournamentEntity.getTournamentId());

        return this.EntitytoResponse(tournamentEntity);
    }

    @Override
    public TournamentResponse read(Long aLong) {
        return tournamentRepository.findById(aLong)
                .map(this::EntitytoResponse)
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

    private TournamentResponse EntitytoResponse(TournamentEntity entity) {
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
