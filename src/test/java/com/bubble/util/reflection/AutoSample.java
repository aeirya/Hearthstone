package com.bubble.util.reflection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLClassLoader;

import com.IBird;

public class AutoSample {

    public static void main(String[] args) {
        try(URLClassLoader ucl = new AutomaticClassLoader("my.jar")) {
            Object ob = ucl.loadClass("com.Hawk").getConstructor().newInstance();
            ((IBird)ob).sing();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }   
}