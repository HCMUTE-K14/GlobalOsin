package com.tghelper.globalosin.utils;

import java.util.UUID;

/**
 * Created by infamouSs on 1/23/18.
 */

public class UUIDGenerator {
    
    public static String randomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
