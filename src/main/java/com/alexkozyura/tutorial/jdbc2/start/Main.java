package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.AircraftDB;
import com.alexkozyura.tutorial.jdbc2.database.implementations.FlightClassDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Aircraft;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.FlightClass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private AircraftDB aircraftDB = AircraftDB.getInstance();

    public static void main(String[] args) {

        ArrayList<Aircraft> aircrafts = new Main().getAllAircrafts();
    }

    public ArrayList<Aircraft> getAllAircrafts() {

        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        try {
            aircrafts.addAll(aircraftDB.getList(aircraftDB.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return aircrafts;
    }
}
