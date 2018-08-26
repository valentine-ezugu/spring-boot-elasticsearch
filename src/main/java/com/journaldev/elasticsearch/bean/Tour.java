package com.journaldev.elasticsearch.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
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
    public String typeOfRest;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> extras  ;


     private Tour() {
     }


    public List<String> getExtras() {
        return extras;
    }

    public void setExtras(List<String> extras) {
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

        public Departure getDeparture() {
            return departure;
        }

        public Arrival getArrival() {
            return arrival;
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
