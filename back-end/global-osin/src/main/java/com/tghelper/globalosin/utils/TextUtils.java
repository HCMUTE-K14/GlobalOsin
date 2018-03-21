package com.tghelper.globalosin.utils;

/**
 * Created by infamouSs on 1/23/18.
 */

public class TextUtils {
    
    private TextUtils() {
        throw new IllegalStateException("Utility class");
    }
    
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
}
