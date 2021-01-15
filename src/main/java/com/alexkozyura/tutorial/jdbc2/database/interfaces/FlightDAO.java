package com.alexkozyura.tutorial.jdbc2.database.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface FlightDAO<Type> {

    int insert(PreparedStatement preparedStatement) throws SQLException;

    Type getRecord(PreparedStatement preparedStatement) throws SQLException, ParseException;

    ArrayList<Type> getRecordList(PreparedStatement preparedStatement) throws SQLException, ParseException;
}
