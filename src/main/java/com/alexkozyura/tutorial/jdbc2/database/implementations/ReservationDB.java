package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.database.implementations.dict.PlaceDB;
import com.alexkozyura.tutorial.jdbc2.objects.Reservation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationDB extends AbstractObjectDB<Reservation> {

    private static ReservationDB instance;

    public static final String TABLE_NAME = "reservation";
    public static final String FIELD_ID = "r_id";
    public static final String FIELD_FLIGHT_ID = "r_flight_id";
    public static final String FIELD_PASSENGER_ID = "r_passenger_id";
    public static final String FIELD_PLACE_ID = "r_place_id";
    public static final String FIELD_ADD_INFO = "r_add_info";
    public static final String FIELD_RESERVE_DATETIME = "r_reserve_datetime";
    public static final String FIELD_CODE = "r_code";

    private ReservationDB() {
        super(TABLE_NAME);
    }

    public static ReservationDB getInstance() {

        if (instance == null) {
            instance = new ReservationDB();
        }

        return instance;
    }


    @Override
    public Reservation fillObject(ResultSet resultSet) throws SQLException, ParseException {

        Reservation reservation = new Reservation();

        FlightDB flightDb = FlightDB.getInstance();
        PassengerDB passengerDb = PassengerDB.getInstance();
        PlaceDB placeDb = PlaceDB.getInstance();

        SimpleDateFormat simpleDateTimeFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        reservation.setId(resultSet.getLong(FIELD_ID));

        reservation.setFlight(
                flightDb.getRecord(
                        flightDb.getRecordStatement(
                                FlightDB.FIELD_ID,
                                resultSet.getLong(FIELD_FLIGHT_ID))
                )
        );

        reservation.setPassenger(
                passengerDb.getRecord(
                        passengerDb.getRecordStatement(
                                PassengerDB.FIELD_ID,
                                resultSet.getLong(FIELD_PASSENGER_ID))
                )
        );

        reservation.setPlace(
                placeDb.getRecord(
                        placeDb.getRecordStatement(
                                PlaceDB.FIELD_ID,
                                resultSet.getLong(FIELD_PLACE_ID))
                )
        );

        reservation.setAddInfo(resultSet.getString(FIELD_ADD_INFO));

        reservation.setReserveDateTime(simpleDateTimeFormat.parse(resultSet.getString(FIELD_RESERVE_DATETIME)));

        reservation.setCode(resultSet.getString(FIELD_CODE));

        return reservation;
    }
}
