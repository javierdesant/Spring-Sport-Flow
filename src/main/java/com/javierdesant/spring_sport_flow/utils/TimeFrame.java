package com.javierdesant.spring_sport_flow.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeFrame {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public TimeFrame(LocalDate startDate, LocalDate endDate) {
        assert startDate.isBefore(endDate);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TimeFrame(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.startDate = LocalDate.parse(startDate, formatter);
        this.endDate = LocalDate.parse(endDate, formatter);
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public boolean includes(LocalDate date) {
        return this.startDate.isBefore(date) && this.endDate.isAfter(date);
    }

    public boolean includesNow() {
        return this.includes(LocalDate.now());
    }
}