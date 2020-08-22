package com.bubble.util.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.IBird;

public class DynamicSample {
    public static void main(String[] args) {
        try (DynamicClassLoader dcl = new DynamicClassLoader(ClassLoader.getSystemClassLoader())) {
            dcl.add(new File("my.jar").toURI().toURL());
            Class<?> clazz = dcl.loadClass("com.Hawk");
            Object obj = clazz.getConstructor().newInstance();
            ((IBird) obj).sing();
        } catch (IOException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}