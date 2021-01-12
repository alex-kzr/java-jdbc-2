package com.alexkozyura.tutorial.jdbc2.database.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface Statements {

    PreparedStatement getStatement(String idFieldName, long id) throws SQLException;

    PreparedStatement getStatementAll() throws SQLException;
}
