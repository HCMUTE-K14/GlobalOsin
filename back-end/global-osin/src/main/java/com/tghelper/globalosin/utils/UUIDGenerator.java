package com.tghelper.globalosin.utils;

import java.util.UUID;

/**
 * Created by infamouSs on 1/23/18.
 */

public class UUIDGenerator {
    
    private UUIDGenerator() {
        throw new IllegalStateException("Utility class");
    }
    
    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
