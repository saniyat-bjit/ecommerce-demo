package com.saniyat.ecommerce_demo.amscheck;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import org.junit.jupiter.api.Test;

/** amscheck-polyglot/web must not resolve a lodash release below 4.18.0 (CVE-2021-23337 and others). */
class LodashLockVersionTest {

    private static final File LOCK = new File("amscheck-polyglot/web/package-lock.json");

    @Test
    void lockResolvesLodashAtLeast4_18_0() throws Exception {
        JsonNode root = new ObjectMapper().readTree(LOCK);
        String resolved = root.path("packages").path("node_modules/lodash").path("version").asText();
        assertTrue(compare(resolved, "4.18.0") >= 0,
                "package-lock.json resolves lodash " + resolved + ", below 4.18.0");
    }

    private static int compare(String a, String b) {
        String[] x = a.split("[.-]");
        String[] y = b.split("[.-]");
        for (int i = 0; i < 3; i++) {
            int c = Integer.compare(Integer.parseInt(x[i]), Integer.parseInt(y[i]));
            if (c != 0) {
                return c;
            }
        }
        return 0;
    }
}
