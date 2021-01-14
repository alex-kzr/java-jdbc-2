package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.PassengerDB;
import com.alexkozyura.tutorial.jdbc2.objects.Passenger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private PassengerDB passengerDb = PassengerDB.getInstance();

    public static void main(String[] args) {

        ArrayList<Passenger> passengers = new Main().getAllPassengers();
    }

    public ArrayList<Passenger> getAllPassengers() {

        ArrayList<Passenger> passengers = new ArrayList<>();

        try {
            passengers.addAll(passengerDb.getList(passengerDb.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return passengers;
    }
}
