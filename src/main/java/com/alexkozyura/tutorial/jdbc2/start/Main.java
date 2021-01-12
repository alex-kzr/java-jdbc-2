package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.PlaceDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Place;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private PlaceDB placeDB = PlaceDB.getInstance();

    public static void main(String[] args) {

        ArrayList<Place> places = new Main().getAllPlaces();
    }

    public ArrayList<Place> getAllPlaces() {

        ArrayList<Place> places = new ArrayList<>();

        try {
            places.addAll(placeDB.getList(placeDB.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return places;
    }
}
