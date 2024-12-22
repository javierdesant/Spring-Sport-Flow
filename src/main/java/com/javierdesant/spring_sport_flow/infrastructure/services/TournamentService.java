package com.javierdesant.spring_sport_flow.infrastructure.services;

import com.javierdesant.spring_sport_flow.api.dto.requests.TournamentRequest;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
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
    public TournamentEntity create(TournamentRequest request) {
        LeagueEntity leagueEntity = getLeagueById(request.getLeagueCode());
        SportEntity sportEntity = getSportById(request.getSportCode());
        CategoryEntity categoryEntity = getCategoryById(request.getCategoryCode());

        TimeFrame tournamentTimeFrame = new TimeFrame(request.getStartDate(), request.getEndDate());

        TournamentEntity tournamentEntity = TournamentEntity.builder().tournamentName(request.getTournamentName()).league(leagueEntity).sport(sportEntity).category(categoryEntity).timeFrame(tournamentTimeFrame).build();

        TournamentEntity savedTournament = tournamentRepository.save(tournamentEntity);
        log.info("Tournament '{} (ID: {})' saved successfully.", savedTournament.getTournamentName(), savedTournament.getTournamentId());

        return savedTournament;
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
    public TournamentEntity read(Long aLong) {
        return tournamentRepository.findById(aLong)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public TournamentEntity update(TournamentRequest request, Long id) {
        TournamentEntity tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tournament not found with id: " + id));

        LeagueEntity league = fetchEntityById(leagueRepository, request.getLeagueCode(), "League");
        SportEntity sport = fetchEntityById(sportRepository, request.getSportCode(), "Sport");
        CategoryEntity category = fetchEntityById(categoryRepository, request.getCategoryCode(), "Category");

        TimeFrame timeFrame = new TimeFrame(request.getStartDate(), request.getEndDate());

        tournament = tournament.toBuilder()
                .tournamentName(request.getTournamentName())
                .league(league)
                .sport(sport)
                .category(category)
                .timeFrame(timeFrame)
                .build();

        TournamentEntity updatedTournament = tournamentRepository.save(tournament);

        log.info("Tournament updated with id: {}", updatedTournament.getTournamentId());

        return updatedTournament;
    }

    private <T> T fetchEntityById(CrudRepository<T, String> repository, String id, String entityName) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(entityName + " not found with id: " + id));
    }

    @Override
    public void delete(Long aLong) {
        tournamentRepository.deleteById(aLong);
    }

    @Override
    public Page<TournamentEntity> listAll(Pageable pageable) {
        return tournamentRepository.findAll(pageable);
    }
}
