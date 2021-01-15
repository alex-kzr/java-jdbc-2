package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.ReservationDB;
import com.alexkozyura.tutorial.jdbc2.objects.Reservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private ReservationDB reservationDb = ReservationDB.getInstance();

    public static void main(String[] args) {

        ArrayList<Reservation> reservations = new Main().getAllReservations();
    }

    public ArrayList<Reservation> getAllReservations() {

        ArrayList<Reservation> reservations = new ArrayList<>();

        try {
            reservations.addAll(
                    reservationDb.getRecordList(
                            reservationDb.getAllRecordsStatement()
                    )
            );
        } catch (SQLException sqlException) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, sqlException);
        } catch (ParseException parseException) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, parseException);
        }

        return reservations;
    }
}
