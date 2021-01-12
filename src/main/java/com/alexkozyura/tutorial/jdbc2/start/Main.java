package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.FlightClassDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.FlightClass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private FlightClassDB flightClassDB = FlightClassDB.getInstance();

    public static void main(String[] args) {

        ArrayList<FlightClass> flightClasses = new Main().getAllFlightClasses();
    }

    public ArrayList<FlightClass> getAllFlightClasses() {

        ArrayList<FlightClass> flightClasses = new ArrayList<>();

        try {
            flightClasses.addAll(flightClassDB.getList(flightClassDB.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return flightClasses;
    }
}
