package com.saniyat.ecommerce_demo.amscheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Planted for AMS's Java lint check: two likely bugs. */
public class OrderLookup {

    public boolean isPaid(String status) {
        // A string compared by reference: false even when the text matches.
        return status == "PAID";
    }

    public int countOrders(String url) throws SQLException {
        // A connection, statement and result set never closed.
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet rows = statement.executeQuery("SELECT COUNT(*) FROM orders");
        rows.next();
        return rows.getInt(1);
    }
}
