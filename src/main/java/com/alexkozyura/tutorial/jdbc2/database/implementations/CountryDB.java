package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDB extends AbstractObjectDB<Country> {

    public final static String TABLE_DIRECTORY_COUNTRY = "dict_country";
    private static CountryDB instance;

    private CountryDB() {
        super(TABLE_DIRECTORY_COUNTRY);
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

        country.setId(resultSet.getLong("dcn_id"));
        country.setName(resultSet.getString("dcn_name"));
        country.setCode(resultSet.getString("dcn_code"));
        country.setFlag(resultSet.getBytes("dcn_flag"));
        country.setDescription((resultSet.getString("dcn_description")));

        return country;
    }
}
