package com.journaldev.elasticsearch.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
 public class Tour {

    private String id;
    private Departure departure;
    private Arrival arrival;
    private TourType tourType;
    private Hotel hotel;
    private String nights;
    private int people;
    private int price;
    private String typeOfRest;
    private List extras  ;


     private Tour() {
     }

    public List getExtras() {
        return extras;
    }

    public void setExtras(List extras) {
        this.extras = extras;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public String getNights() {
        return nights;
    }

    public void setNights(String nights) {
        this.nights = nights;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfRest() {
        return typeOfRest;
    }

    public void setTypeOfRest(String typeOfRest) {
        this.typeOfRest = typeOfRest;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class TourBuilder {

        private static final  String DEPARTURE = "departure";
        private static final String ARRIVAL = "arrival";
        private static final String TOURTYPE = "tourType";
        private static final String HOTEL = "hotel";
        private static final String BEACH = "beach";
        private String country;
        private String distanceToAirport;
        private List extras;
        private List facilities;
        private String photoUrl;
        private String regionName;
        private String title;
        private Departure departure;
        private Arrival arrival;
        private TourType tourType;
        private Hotel hotel;


        /**
         *
         * @param departure
         * @param arrival
         * @param tourType
         * @param hotel
         */
        public TourBuilder(Departure departure, Arrival arrival, TourType tourType, Hotel hotel) {
            this.departure = departure;
            this.arrival = arrival;
            this.tourType = tourType;
            this.hotel = hotel;
        }

        public TourBuilder() {
        }

        TourBuilder setCountry(String country){
            this.country = country;
            return this;
        }


        TourBuilder setDistanceToAirport(String distanceToAirport){
            this.distanceToAirport = distanceToAirport;
            return this;
        }


        TourBuilder setExtras(List extras){
            this.extras = extras;
            return this;
        }


        TourBuilder setFacilities(List facilities){
            this.facilities = facilities;
            return this;
        }

        TourBuilder setPhotoUrl(String photoUrl){
            this.photoUrl = photoUrl;
            return this;
        }

        TourBuilder setRegionName(String regionName){
            this.regionName = regionName;
            return this;
        }

        TourBuilder setTitle(String title){
            this.title = title;
            return this;
        }


        TourBuilder setDeparture(Departure departure){
            this.departure = departure;
            return this;
        }

        TourBuilder setArrival(Arrival arrival) {
            this.arrival = arrival;
            return this;
        }

        TourBuilder SetTourType(TourType tourType) {
            this.tourType = tourType;
            return this;
        }

        TourBuilder setHotel(Hotel hotel) {
            this.hotel = hotel;
            return this;
        }


        public Tour build() {
            Tour tour = new Tour();
            tour.departure = departure;
            tour.arrival = arrival;
            tour.hotel = hotel;
            tour.tourType = tourType;

            return tour;
        }

    }

}
