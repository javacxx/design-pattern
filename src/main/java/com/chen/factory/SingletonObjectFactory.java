package com.chen.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author CXX
 * @date 2019/5/7 14:20
 */

public class SingletonObjectFactory {
    private SingletonObjectFactory(){};

    private static volatile Map<String, Object> singletonObjectsMap =
            new ConcurrentHashMap<>();

    public static <T> T getSingleton(Class<T> c) {
        String className = c.getName();
        if (!singletonObjectsMap.containsKey(className)) {
            synchronized (c.getClass()){
                if (!singletonObjectsMap.containsKey(className)) {
                    T t = createInstance(className);
                    singletonObjectsMap.put(className, t);
              //    singletonObjectsMap.putIfAbsent(className, t);
                }
            }
        }
        return (T) singletonObjectsMap.get(className);
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
