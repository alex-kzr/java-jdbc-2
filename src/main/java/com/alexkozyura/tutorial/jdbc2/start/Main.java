package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.FlightDB;
import com.alexkozyura.tutorial.jdbc2.objects.Flight;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private FlightDB flightDb = FlightDB.getInstance();

    public static void main(String[] args) {

        ArrayList<Flight> flights = new Main().getAllFlights();
    }

    public ArrayList<Flight> getAllFlights() {

        ArrayList<Flight> flights = new ArrayList<>();

        try {
            flights.addAll(flightDb.getList(flightDb.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        } catch (ParseException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return flights;
    }
}
