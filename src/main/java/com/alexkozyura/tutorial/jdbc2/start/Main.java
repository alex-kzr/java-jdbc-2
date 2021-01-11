package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.SQLiteConnection;
import com.alexkozyura.tutorial.jdbc2.database.implementations.CountryDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Country;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private CountryDB countryDB = CountryDB.getInstance();

    public static void main(String[] args) {

        ArrayList<Country> countries = new Main().getAllCountries();
    }

    public ArrayList<Country> getAllCountries() {

        ArrayList<Country> countries = new ArrayList<>();

        try {
            countries.addAll(countryDB.getList(countryDB.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return countries;
    }
}
