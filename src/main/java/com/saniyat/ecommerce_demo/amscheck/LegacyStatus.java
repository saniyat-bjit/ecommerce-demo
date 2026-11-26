package com.saniyat.ecommerce_demo.amscheck;

/** Planted for AMS's Java lint check: a bug a // NOPMD comment hides from PMD, not from AMS. */
public class LegacyStatus {

    public boolean isArchived(String status) {
        return status == "ARCHIVED"; // NOPMD
    }
}
