package com.tghelper.globalosin.core;

import com.tghelper.globalosin.utils.TextUtils;

/**
 * Created by infamouSs on 1/26/18.
 */

public final class PreCondition {
    
    private PreCondition() {
        throw new IllegalStateException("Utility class");
    }
    
    public static void isTrue(boolean expression, String errorMessageTemplate,
              Object... errorMessageArguments) {
        isTrue(expression, String.format(errorMessageTemplate, errorMessageArguments));
    }
    
    public static void isTrue(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    
    public static void notEmpty(String string, String errorMessage) {
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    
    public static void notEmpty(String string, ApplicationMessage error) {
        notEmpty(string, error.getMessage());
    }
    
    public static void notNull(Object reference, String errorMessage) {
        if (reference == null) {
            throw new NullPointerException(errorMessage);
        }
    }
    
    public static void notNull(Object reference, ApplicationMessage error) {
        notNull(reference, error.getMessage());
    }
    
    
}
