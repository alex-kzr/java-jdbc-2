package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDB extends AbstractObjectDB {

    private static CompanyDB instance;

    public final static String TABLE_NAME = "dict_company";
    public final static String FIELD_ID = "dcm_id";
    public final static String FIELD_NAME = "dcm_name";
    public final static String FIELD_DESCRIPTION = "dcm_description";
    public final static String FIELD_ICON = "dcm_icon";

    private CompanyDB() {
        super(TABLE_NAME);
    }

    public static CompanyDB getInstance() {

        if (instance == null) {
            instance = new CompanyDB();
        }

        return instance;
    }

    @Override
    public Company fillObject(ResultSet resultSet) throws SQLException {

        Company company = new Company();

        company.setId(resultSet.getLong(FIELD_ID));
        company.setName(resultSet.getString(FIELD_NAME));
        company.setDescription(resultSet.getString(FIELD_DESCRIPTION));
        company.setIcon(resultSet.getBytes(FIELD_ICON));

        return company;
    }
}
