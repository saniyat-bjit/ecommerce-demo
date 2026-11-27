package com.saniyat.ecommerce_demo.amscheck;

/** Lazily created singleton, initialised safely through the holder-class idiom. */
public class CacheHolder {

    private static final class Holder {
        private static final CacheHolder INSTANCE = new CacheHolder();
    }

    public static CacheHolder get() {
        return Holder.INSTANCE;
    }
}
