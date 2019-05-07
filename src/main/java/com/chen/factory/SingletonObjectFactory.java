package com.chen.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CXX
 * @date 2019/5/7 14:20
 */

public class SingletonObjectFactory {
    private SingletonObjectFactory(){};

    private static final Map<String, Object> singletonObjects =
            new HashMap<>();

    public synchronized static <T> T getSingleton(Class<T> c) {
        String className = c.getName();
        if (!singletonObjects.containsKey(className)) {
            T t = createInstance(className);
            singletonObjects.put(className, t);
        }
        return (T) singletonObjects.get(className);
    }

    private static <T> T createInstance(String className) {
        try {
            return createInstanceReference(className);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T createInstanceReference(String className) throws Exception {
        Class class1 = Class.forName(className);
        Constructor constructor = class1.getDeclaredConstructor();
        constructor.setAccessible(Boolean.TRUE);
        T t = (T) constructor.newInstance();
        return t;
    }



}
