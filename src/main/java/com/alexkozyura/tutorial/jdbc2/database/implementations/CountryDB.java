package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDB extends AbstractObjectDB<Country> {

    public final static String TABLE_NAME = "dict_country";
    public final static String FIELD_ID = "dcn_id";
    public final static String FIELD_NAME = "dcn_name";
    public final static String FIELD_CODE = "dcn_code";
    public final static String FIELD_FLAG = "dcn_flag";
    public final static String FIELD_DESCRIPTION = "dcn_description";

    private static CountryDB instance;

    private CountryDB() {
        super(TABLE_NAME);
    }

    public static CountryDB getInstance() {

        if (instance == null) {
            instance = new CountryDB();
        }

        return instance;
    }

    @Override
    public Country fillObject(ResultSet resultSet) throws SQLException {
        Country country = new Country();

        country.setId(resultSet.getLong(FIELD_ID));
        country.setName(resultSet.getString(FIELD_NAME));
        country.setCode(resultSet.getString(FIELD_CODE));
        country.setFlag(resultSet.getBytes(FIELD_FLAG));
        country.setDescription((resultSet.getString(FIELD_DESCRIPTION)));

        return country;
    }
}
