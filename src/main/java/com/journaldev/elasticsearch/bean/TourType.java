package com.journaldev.elasticsearch.bean;

public class TourType {

    private int price;

    private byte people;

    private String typeOfRest;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte getNumberOfPeople() {
        return people;
    }

    public void setNumberOfPeople(byte numberOfPeople) {
        this.people = numberOfPeople;
    }

    public String getTypeOfTour() {
        return typeOfRest;
    }

    public void setTypeOfTour(String typeOfTour) {
        this.typeOfRest = typeOfTour;
    }

}
