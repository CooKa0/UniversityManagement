package com.solvd.laba.university.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionUtil {

    public static void printClassInfo(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());

        // Print constructors
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(" " + constructor);
        }

        // Print fields
        System.out.println("\nFields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(" " + Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " " + field.getName());
        }

        // Print methods
        System.out.println("\nMethods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(" " + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName());
        }
    }

    public static Object createInstance(Class<?> clazz, Class<?>[] paramTypes, Object... params) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor(paramTypes);
        constructor.setAccessible(true);
        return constructor.newInstance(params);
    }

    public static Object callMethod(Object instance, String methodName, Class<?>[] paramTypes, Object... params) throws Exception {
        Method method = instance.getClass().getDeclaredMethod(methodName, paramTypes);
        method.setAccessible(true);
        return method.invoke(instance, params);
    }
}