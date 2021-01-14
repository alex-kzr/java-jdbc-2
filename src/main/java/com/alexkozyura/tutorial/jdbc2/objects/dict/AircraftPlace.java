package com.alexkozyura.tutorial.jdbc2.objects.dict;

public class AircraftPlace {

    private long id;
    private Aircraft aircraft;
    private Place place;
    private FlightClass flightClass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }
}
