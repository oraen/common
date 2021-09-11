package com.oraen.oxygen.common.model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class GlobalConfig {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static Charset getDefaultCharset() {
        return DEFAULT_CHARSET;
    }
}
