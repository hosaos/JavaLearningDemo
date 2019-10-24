package com.demo.util;

import org.slf4j.MDC;

/**
 * @author: chenyin
 * @date: 2019-10-24 10:41
 */
public class MdcUtil {
    public static String get(String key) {
        return MDC.get(key);
    }

    public static void put(String key, String value) {
        MDC.put(key, value);
    }

    public static void clear() {
        MDC.clear();
    }
}
