package com.bubble.util.reflection;

import java.lang.reflect.InvocationTargetException;

import com.IBird;

public class CustomLoaderSample {
    public static void main(String[] args) {
        try {
            ((IBird) new CustomClassLoader().load("my.jar", "com.Hawk").getConstructor().newInstance()).sing();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }   
}