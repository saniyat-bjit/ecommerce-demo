package com.saniyat.ecommerce_demo.amscheck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

class OrderLookupResourceTest {

    @Test
    void isPaidComparesTextNotReference() {
        OrderLookup lookup = new OrderLookup();
        assertTrue(lookup.isPaid(new String("PAID")));
        assertFalse(lookup.isPaid("PENDING"));
        assertFalse(lookup.isPaid(null));
    }

    @Test
    void countOrdersClosesItsConnection() throws Exception {
        String url = "jdbc:h2:mem:orderlookup";
        try (Connection holder = DriverManager.getConnection(url);
                Statement setup = holder.createStatement()) {
            setup.execute("CREATE TABLE orders (id INT)");
            setup.execute("INSERT INTO orders VALUES (1), (2), (3)");

            assertEquals(3, new OrderLookup().countOrders(url));

            try (ResultSet sessions = setup.executeQuery(
                    "SELECT COUNT(*) FROM INFORMATION_SCHEMA.SESSIONS")) {
                sessions.next();
                assertEquals(1, sessions.getInt(1), "countOrders left its connection open");
            }
        }
    }
}
