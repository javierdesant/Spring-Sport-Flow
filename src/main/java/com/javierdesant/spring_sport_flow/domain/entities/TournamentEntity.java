package com.javierdesant.spring_sport_flow.domain.entities;

import com.javierdesant.spring_sport_flow.utils.TimeFrame;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "tournaments")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class TournamentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentId;

    @Column(length = 150, unique = true, nullable = false)
    private String tournamentName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "startDate", column = @Column(nullable = false)),
            @AttributeOverride(name = "endDate", column = @Column(nullable = false))
    })
    private TimeFrame timeFrame;

    @ManyToOne
    @JoinColumn(name = "league_code", nullable = false)
    private LeagueEntity league;

    @ManyToOne
    @JoinColumn(name = "sport_code", nullable = false)
    private SportEntity sport;

    @ManyToOne
    @JoinColumn(name = "category_code", nullable = false)
    private CategoryEntity category;

    public LocalDate getStartDate() {
        return this.timeFrame != null ? this.timeFrame.getStartDate() : null;
    }

    public LocalDate getEndDate() {
        return this.timeFrame != null ? this.timeFrame.getEndDate() : null;
    }

    public void setStartDate(LocalDate startDate) {
        if (this.timeFrame == null) {
            this.timeFrame = new TimeFrame();
        }
        this.timeFrame.setStartDate(startDate);
    }

    public void setEndDate(LocalDate endDate) {
        if (this.timeFrame == null) {
            this.timeFrame = new TimeFrame();
        }
        this.timeFrame.setEndDate(endDate);
    }
}
