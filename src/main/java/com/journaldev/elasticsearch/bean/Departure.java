package com.journaldev.elasticsearch.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Departure {

    private String city;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM d, yyyy hh:mm:ss a")
    private LocalDateTime date;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
