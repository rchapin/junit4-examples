package com.ryanchapin.examples;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static int add(String label, int x, int y) {
        LOGGER.log(Level.INFO, "Processing addition for label={}", label);
        Utils.doSomething(label, x, y);
        return x + y;
    }

    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }
}
