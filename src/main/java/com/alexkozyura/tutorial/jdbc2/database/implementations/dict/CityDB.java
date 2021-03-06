package com.alexkozyura.tutorial.jdbc2.database.implementations.dict;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.objects.dict.City;
import com.alexkozyura.tutorial.jdbc2.objects.dict.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class CityDB extends AbstractObjectDB<City> {

    private static CityDB instance;

    public final static String TABLE_NAME = "dict_city";
    public final static String FIELD_ID = "dc_id";
    public final static String FIELD_NAME = "dc_name";
    public final static String FIELD_COUNTRY_ID = "dc_country_id";
    public final static String FIELD_DESCRIPTION = "dc_description";

    private CityDB() {
        super(TABLE_NAME);
    }

    public static CityDB  getInstance() {

        if (instance == null) {
            instance = new CityDB();
        }

        return instance;
    }

    @Override
    public City fillObject(ResultSet resultSet) throws SQLException, ParseException {

        City city = new City();

        city.setId(resultSet.getLong(FIELD_ID));
        city.setName(resultSet.getString(FIELD_NAME));

        Country country = CountryDB.getInstance().getRecord(CountryDB.getInstance().getRecordStatement(CountryDB.FIELD_ID ,resultSet.getLong(FIELD_COUNTRY_ID)));

        city.setCountry(country);
        city.setDescription(resultSet.getString(FIELD_DESCRIPTION));

        return city;
    }
}
