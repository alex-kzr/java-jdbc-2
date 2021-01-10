package com.alexkozyura.tutorial.jdbc2.database.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FillObject<Type> {

    Type fillObject(ResultSet resultSet) throws SQLException;
}
