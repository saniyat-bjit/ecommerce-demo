package com.saniyat.ecommerce_demo.amscheck;

/** Planted for AMS's Java lint check: lint in test code goes to the summary. */
class OrderLookupTest {

    private String unused = "never read";

    boolean paid() {
        return new OrderLookup().isPaid("PAID");
    }
}
