package com.alexkozyura.tutorial.jdbc2.database.implementations.dict;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Place;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceDB extends AbstractObjectDB<Place> {

    private static PlaceDB instance;

    public static final String TABLE_NAME = "dict_place";
    public static final String FIELD_ID = "dp_id";
    public static final String FIELD_SEAT_LETTER = "dp_seat_letter";
    public static final String FIELD_SEAT_NUMBER = "dp_seat_number";

    private PlaceDB() {
        super(TABLE_NAME);
    }

    public static PlaceDB getInstance() {
        if (instance == null) {
            instance = new PlaceDB();
        }

        return instance;
    }

    @Override
    public Place fillObject(ResultSet resultSet) throws SQLException {

        Place place = new Place();

        place.setId(resultSet.getLong(FIELD_ID));
        place.setSeatLetter(resultSet.getString(FIELD_SEAT_LETTER));
        place.setSeatNumber(resultSet.getInt(FIELD_SEAT_NUMBER));

        return place;
    }
}
