package com.alexkozyura.tutorial.jdbc2.database.implementations;

import com.alexkozyura.tutorial.jdbc2.database.abstracts.AbstractObjectDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDB extends AbstractObjectDB {

    public final static String TABLE_DIRECTORY_COMPANY = "dict_company";

    private CompanyDB() {
        super(TABLE_DIRECTORY_COMPANY);
    }

    private static CompanyDB instance;

    public static CompanyDB getInstance() {

        if (instance == null) {
            instance = new CompanyDB();
        }

        return instance;
    }

    @Override
    public Company fillObject(ResultSet resultSet) throws SQLException {

        Company company = new Company();

        company.setId(resultSet.getLong("dcm_id"));
        company.setName(resultSet.getString("dcm_name"));
        company.setDescription(resultSet.getString("dcm_description"));
        company.setIcon(resultSet.getBytes("dcm_icon"));

        return company;
    }
}
