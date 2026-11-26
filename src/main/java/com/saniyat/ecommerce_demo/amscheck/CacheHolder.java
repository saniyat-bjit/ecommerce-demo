package com.saniyat.ecommerce_demo.amscheck;

/** Planted for AMS's Java lint check: double-checked locking without volatile. */
public class CacheHolder {

    private static CacheHolder instance;

    public static CacheHolder get() {
        if (instance == null) {
            synchronized (CacheHolder.class) {
                if (instance == null) {
                    instance = new CacheHolder();
                }
            }
        }
        return instance;
    }
}
