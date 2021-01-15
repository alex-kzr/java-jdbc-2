package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.database.implementations.dict.AircraftDB;
import com.alexkozyura.tutorial.jdbc2.database.implementations.dict.CityDB;
import com.alexkozyura.tutorial.jdbc2.objects.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FlightDB extends AbstractObjectDB<Flight> {

    private static FlightDB instance;

    public static final String TABLE_NAME = "flight";
    public static final String FIELD_ID = "f_id";
    public static final String FIELD_CODE = "f_code";
    public static final String FIELD_DEPARTURE_DATE = "f_departure_date";
    public static final String FIELD_ARRIVAL_DATE = "f_arrival_date";
    public static final String FIELD_AIRCRAFT_ID = "f_aircraft_id";
    public static final String FIELD_DEPARTURE_CITY_ID = "f_departure_city_id";
    public static final String FIELD_ARRIVAL_CITY_ID = "f_arrival_city_id";
    public static final String FIELD_PRICE = "price";

    private FlightDB() {
        super(TABLE_NAME);
    }

    public static FlightDB getInstance() {

        if (instance == null) {
            instance = new FlightDB();
        }

        return instance;
    }

    @Override
    public Flight fillObject(ResultSet resultSet) throws SQLException, ParseException {

        Flight flight = new Flight();

        AircraftDB aircraftDb = AircraftDB.getInstance();
        CityDB cityDb = CityDB.getInstance();

        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd");

        flight.setId(resultSet.getLong(FIELD_ID));
        flight.setCode(resultSet.getString(FIELD_CODE));
        flight.setDepartureDate(simpleDateFormat.parse(resultSet.getString(FIELD_DEPARTURE_DATE)));
        flight.setArrivalDate(simpleDateFormat.parse(resultSet.getString(FIELD_ARRIVAL_DATE)));

        flight.setAircraft(aircraftDb
                .getRecord(aircraftDb
                        .getRecordStatement(aircraftDb.FIELD_ID,
                                resultSet.getLong(FIELD_AIRCRAFT_ID))));

        flight.setDepartureCity(cityDb
                .getRecord(cityDb
                        .getRecordStatement(cityDb.FIELD_ID,
                                resultSet.getLong(FIELD_DEPARTURE_CITY_ID))));

        flight.setArrivalCity(cityDb
                .getRecord(cityDb
                        .getRecordStatement(cityDb.FIELD_ID,
                                resultSet.getLong(FIELD_ARRIVAL_CITY_ID))));

        flight.setPrice(resultSet.getInt(FIELD_PRICE));

        return flight;
    }
}
