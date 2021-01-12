package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.FlightClass;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightClassDB extends AbstractObjectDB<FlightClass> {

    private static FlightClassDB instance;

    public final static String TABLE_NAME = "dict_flight_class";
    public final static String FIELD_ID = "dfc_id";
    public final static String FIELD_NAME = "dfc_name";
    public final static String FIELD_DESCRIPTION = "dfc_description";

    private FlightClassDB() {
        super(TABLE_NAME);
    }

    public static FlightClassDB getInstance() {

        if (instance == null) {
            instance = new FlightClassDB();
        }

        return instance;
    }

    @Override
    public FlightClass fillObject(ResultSet resultSet) throws SQLException {

        FlightClass flightClass = new FlightClass();

        flightClass.setId(resultSet.getLong(FIELD_ID));
        flightClass.setName(resultSet.getString(FIELD_NAME));
        flightClass.setDescription(resultSet.getString(FIELD_DESCRIPTION));

        return flightClass;
    }
}
