package com.alexkozyura.tutorial.jdbc2.database.implementations.dict;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.objects.dict.Aircraft;
import com.alexkozyura.tutorial.jdbc2.objects.dict.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class AircraftDB extends AbstractObjectDB<Aircraft> {

    private static AircraftDB instance;

    public final static String TABLE_NAME = "dict_aircraft";
    public final static String FIELD_ID = "da_id";
    public final static String FIELD_NAME = "da_name";
    public final static String FIELD_COMPANY_ID = "da_company_id";
    public final static String FIELD_DESCRIPTION = "da_description";

    private AircraftDB() {
        super(TABLE_NAME);
    }

    public static AircraftDB getInstance() {

        if (instance == null) {
            instance = new AircraftDB();
        }

        return instance;
    }

    @Override
    public Aircraft fillObject(ResultSet resultSet) throws SQLException, ParseException {

        Aircraft aircraft = new Aircraft();

        aircraft.setId(resultSet.getLong(FIELD_ID));
        aircraft.setName(resultSet.getString(FIELD_NAME));

        Company company = CompanyDB.getInstance().get(CompanyDB.getInstance().getStatement(CompanyDB.FIELD_ID, resultSet.getLong(FIELD_COMPANY_ID)));
        aircraft.setCompany(company);

        aircraft.setDescription(resultSet.getString(FIELD_DESCRIPTION));

        return aircraft;
    }
}
