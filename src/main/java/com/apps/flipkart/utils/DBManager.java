package com.apps.flipkart.utils;

import org.junit.Assert;

import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBManager {
    public DBManager() {
    }

    public static List<HashMap<String, Object>> executeQuery(String query, String dbUrl, String username, String password) {
        List list = null;

        try {
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = resultSetToArrayList(resultSet);
            statement.close();
            con.close();
        } catch (SQLException var8) {
            Assert.fail("SQL EXCEPTION OCCURRED: " + var8.getLocalizedMessage());
        }

        return list;
    }

    public static List<HashMap<String, Object>> resultSetToArrayList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        ArrayList list = new ArrayList(5);

        while(rs.next()) {
            HashMap<String, Object> row = new HashMap(columns);

            for(int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getString(i) != null ? rs.getString(i) : "No Value Registered in DB");
            }

            list.add(row);
        }

        return list;
    }
}
