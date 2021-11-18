package com.hoaipx.learn2021.common.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class MybatisUtil {

    /**
     * Map, Collection, String, Array isEmpty * * @return boolean
     */
    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (((String) o).length() == 0) {
                return true;
            }
        } else if (o instanceof Collection) {
            if (((Collection) o).isEmpty()) {
                return true;
            }
        } else if (o.getClass().isArray()) {
            if (Array.getLength(o) == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).isEmpty()) {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    public static boolean isEmpty(Object o1, Object o2) {
        return isEmpty(o1) && isEmpty(o2);
    }

    public static boolean isEmpty(Object o1, Object o2, Object o3) {
        return isEmpty(o1) && isEmpty(o2) && isEmpty(o3);
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isNotEmpty(Object o1, Object o2) {
        return !isEmpty(o1) && !isEmpty(o2);
    }

    public static boolean isNotEmpty(Object o1, Object o2, Object o3) {
        return !isEmpty(o1) && !isEmpty(o2) && !isEmpty(o3);
    }

    public static boolean isNumber(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Number) {
            return true;
        }
        if (o instanceof String) {
            String str = (String) o;
            return !StringUtils.isEmpty(str) && org.apache.commons.lang.StringUtils.isNumeric(str);
        }
        return false;
    }

}
