package com.javierdesant.spring_sport_flow.utils;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class TimeFrame {
    private LocalDate startDate;
    private LocalDate endDate;

    public TimeFrame(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.startDate = LocalDate.parse(startDate, formatter);
        this.endDate = LocalDate.parse(endDate, formatter);
    }

    public boolean includes(LocalDate date) {
        return this.startDate.isBefore(date) && this.endDate.isAfter(date);
    }

    public boolean includesNow() {
        return this.includes(LocalDate.now());
    }
}