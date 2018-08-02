package com.journaldev.elasticsearch.bean;

public class Arrival {

    private String country;
    private String city;
    private short nights;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public short getNumberOfNights() {
        return nights;
    }

    public void setNumberOfNights(short numberOfNights) {
        this.nights = numberOfNights;
    }
}
