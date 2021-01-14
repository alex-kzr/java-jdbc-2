package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.AircraftPlaceDB;
import com.alexkozyura.tutorial.jdbc2.database.implementations.PlaceDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.AircraftPlace;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Place;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private AircraftPlaceDB aircraftPlaceDb = AircraftPlaceDB.getInstance();

    public static void main(String[] args) {

        ArrayList<AircraftPlace> aircraftPlaces = new Main().getAllAircraftPlaces();
    }

    public ArrayList<AircraftPlace> getAllAircraftPlaces() {

        ArrayList<AircraftPlace> aircraftPlaces = new ArrayList<>();

        try {
            aircraftPlaces.addAll(aircraftPlaceDb.getList(aircraftPlaceDb.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return aircraftPlaces;
    }
}
