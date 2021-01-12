package com.alexkozyura.tutorial.jdbc2.start;

import com.alexkozyura.tutorial.jdbc2.database.implementations.CityDB;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.City;
import com.alexkozyura.tutorial.jdbc2.dictionary.objects.Company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private CityDB cityDB = CityDB.getInstance();

    public static void main(String[] args) {

        ArrayList<City> cities = new Main().getAllCities();
    }

    public ArrayList<City> getAllCities() {

        ArrayList<City> cities = new ArrayList<>();

        try {
            cities.addAll(cityDB.getList(cityDB.getStatementAll()));
        } catch (SQLException exception) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, exception);
        }

        return cities;
    }
}
