package com.journaldev.elasticsearch.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Departure {

    private String city;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
