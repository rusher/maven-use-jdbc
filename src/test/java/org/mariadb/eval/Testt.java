package org.mariadb.eval;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.sql.*;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by diego on 15/06/2017.
 */
public class Testt {

    @Test
    public void testtt() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testj?user=root&useSSL=false")) {
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT id, name, null 'nullField' FROM users");
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    System.out.println(resultSetMetaData.getColumnType(i + 1));
                }
            }
        }

    }

}
