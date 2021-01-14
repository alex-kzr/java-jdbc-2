package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Aircraft;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.AircraftPlace;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Place;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AircraftPlaceDB extends AbstractObjectDB<AircraftPlace> {

    private static AircraftPlaceDB instance;

    public static final String TABLE_NAME = "dict_aircraft_place";
    public static final String FIELD_ID = "dap_id";
    public static final String FIELD_AIRCRAFT_ID = "dap_aircraft_id";
    public static final String FIELD_PLACE_ID = "dap_place_id";
    public static final String FIELD_FLIGHT_CLASS_ID = "dap_flight_class_id";

    private AircraftPlaceDB() {
        super(TABLE_NAME);
    }

    public static AircraftPlaceDB getInstance() {

        if (instance == null) {
            instance = new AircraftPlaceDB();
        }

        return instance;
    }

    @Override
    public AircraftPlace fillObject(ResultSet resultSet) throws SQLException {

        AircraftPlace aircraftPlace = new AircraftPlace();

        AircraftDB aircraftDb = AircraftDB.getInstance();
        PlaceDB placeDb = PlaceDB.getInstance();
        FlightClassDB flightClassDb = FlightClassDB.getInstance();

        aircraftPlace.setId(resultSet.getLong(FIELD_ID));

        aircraftPlace.setAircraft(aircraftDb
                .get(aircraftDb
                        .getStatement(aircraftDb.FIELD_ID,
                                resultSet.getLong(FIELD_AIRCRAFT_ID))));

        aircraftPlace.setPlace(placeDb
                .get(placeDb
                        .getStatement(placeDb.FIELD_ID,
                                resultSet.getLong(FIELD_PLACE_ID))));

        aircraftPlace.setFlightClass(flightClassDb
                .get(flightClassDb
                        .getStatement(flightClassDb.FIELD_ID,
                                resultSet.getLong(FIELD_FLIGHT_CLASS_ID))));

        return aircraftPlace;
    }
}
