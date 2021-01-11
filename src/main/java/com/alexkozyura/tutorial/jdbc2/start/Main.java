package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.SQLiteConnection;
import com.alexkozyura.tutorial.jdbc2.database.implementations.CompanyDB;
import com.alexkozyura.tutorial.jdbc2.database.implementations.CountryDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Company;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Country;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private CompanyDB companyDB = CompanyDB.getInstance();

    public static void main(String[] args) {

        ArrayList<Company> companies = new Main().getAllCompanies();
    }

    public ArrayList<Company> getAllCompanies() {

        ArrayList<Company> companies = new ArrayList<>();

        try {
            companies.addAll(companyDB.getList(companyDB.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return companies;
    }
}
