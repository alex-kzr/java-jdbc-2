package com.alexkozyura.tutorial.jdbc2.database.abstracts;

import com.alexkozyura.tutorial.jdbc2.database.interfaces.FillObject;
import com.alexkozyura.tutorial.jdbc2.database.interfaces.FlightDAO;
import com.alexkozyura.tutorial.jdbc2.database.interfaces.Statements;
import com.alexkozyura.tutorial.jdbc2.database.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public abstract class AbstractObjectDB<Type> implements FlightDAO<Type>, FillObject<Type>, Statements {

    public static final int INTERVAL = 1;
    public String tableName;

    public AbstractObjectDB(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public int insert(PreparedStatement preparedStatement) throws SQLException {

        int result = -1;

        try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

            result = preparedStatement.executeUpdate();

            resultSet.next();

            if (resultSet.isFirst()) {
                result = resultSet.getInt(1);
            }
        }

        return result;
    }

    @Override
    public Type getRecord(PreparedStatement preparedStatement) throws SQLException, ParseException {

        Type object = null;

        try (ResultSet resultSet = preparedStatement.executeQuery()) {

            resultSet.next();

            if (resultSet.isFirst()) {
                object = fillObject(resultSet);
            }
        }

        return object;
    }

    @Override
    public ArrayList<Type> getRecordList(PreparedStatement preparedStatement) throws SQLException, ParseException {

        ArrayList<Type> list = new ArrayList<>();

        try (ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                list.add(fillObject(resultSet));
            }
        }

        return list;
    }

    @Override
    public PreparedStatement getRecordStatement(String idFieldName, long id) throws SQLException {

        Connection connection = SQLiteConnection.getInstance().getConnection();

        PreparedStatement  preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName + " WHERE " + idFieldName + "=?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }

    @Override
    public PreparedStatement getAllRecordsStatement() throws SQLException {

        Connection connection = SQLiteConnection.getInstance().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName);

        return preparedStatement;
    }
}
