package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.objects.Passenger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengerDB extends AbstractObjectDB<Passenger> {

    private static PassengerDB instance;

    public static final String TABLE_NAME = "passenger";
    public static final String FIELD_ID = "p_id";
    public static final String FIELD_FORENAME = "p_forename";
    public static final String FIELD_PATRONYMIC = "p_patronymic";
    public static final String FIELD_SURNAME = "p_surname";
    public static final String FIELD_DOCUMENT_NUMBER = "p_document_number";
    public static final String FIELD_EMAIL = "p_email";
    public static final String FIELD_PHONE = "p_phone";

    private PassengerDB() {
        super(TABLE_NAME);
    }

    public static PassengerDB getInstance() {

        if (instance == null) {
            instance = new PassengerDB();
        }

        return instance;
    }

    @Override
    public Passenger fillObject(ResultSet resultSet) throws SQLException {

        Passenger passenger = new Passenger();

        passenger.setId(resultSet.getLong(FIELD_ID));
        passenger.setForename(resultSet.getString(FIELD_FORENAME));
        passenger.setPatronymic(resultSet.getString(FIELD_PATRONYMIC));
        passenger.setSurname(resultSet.getString(FIELD_SURNAME));
        passenger.setDocumentNumber(resultSet.getString(FIELD_DOCUMENT_NUMBER));
        passenger.setEmail(resultSet.getString(FIELD_EMAIL));
        passenger.setPhone(resultSet.getString(FIELD_PHONE));

        return passenger;
    }
}
