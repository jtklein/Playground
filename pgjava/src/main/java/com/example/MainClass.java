package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by johannesklein on 18.11.16.
 */

public class MainClass {

    public static void main(String[] args) {

        System.out.println("MainClass.main");
        System.out.println("args = [" + args + "]");
        lineBreak();

        // Variables

        /*
            Primitive types
         */

        // minimum value of -128 and a maximum value of 127
        byte defaultByte = 0;

        // minimum value of -32,768 and a maximum value of 32,767
        short defaultShort = 0;

        // minimum value of -2E31 and a maximum value of 2E31-1
        int defaultInt = 0;

        // minimum value of -2E63 and a maximum value of 2E63-1
        long defaultLong = 0L;

        float defaultFloat = 0.0f;

        double defaultDouble = 0.0d;

        // minimum value of '\u0000' (or 0) and a maximum value of '\uffff'
        char defaultChar = '\u0000';

        boolean	defaultBoolean = false;

        // Derived types
        String defaultString = null;

        // Primitive array type
        // Cannot be increased once instantiated
        int[] primeNumbers = {2,3,5,7,11,13};

        System.out.println(primeNumbers.length);

        // Lists
        List list = new ArrayList();
        list.add(2);
        list.add(3);
        list.remove(1);

        System.out.println(list.toString());

        // Maps
        Map map = new HashMap<>();

        map.put("Key", "Rob");

        System.out.println(map.get("Key"));
        System.out.println(map.size());

        if (2 > 1){

            System.out.println("Yes");
        }

    }

    public static void lineBreak() {
        System.out.println();
    }
}
