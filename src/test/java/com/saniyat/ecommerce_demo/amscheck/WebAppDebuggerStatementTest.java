package com.saniyat.ecommerce_demo.amscheck;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

/** Regression check for Biome lint/suspicious/noDebugger in amscheck-polyglot/web/src/app.js. */
class WebAppDebuggerStatementTest {

    private static final Pattern DEBUGGER_STATEMENT = Pattern.compile("\\bdebugger\\b");

    @Test
    void appJsHasNoDebuggerStatement() throws Exception {
        String source = Files.readString(Path.of("amscheck-polyglot/web/src/app.js"));
        assertFalse(DEBUGGER_STATEMENT.matcher(source).find(),
                "app.js still contains a left-over debugger statement");
    }
}
