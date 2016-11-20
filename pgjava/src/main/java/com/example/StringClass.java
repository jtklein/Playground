package com.example;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by johannesklein on 20.11.16.
 */

public class StringClass {

    public static void main(String[] args) {

        System.out.println("StringClass.main");
        System.out.println();

        /*
            String manipulations
         */

        // Split String
        String names = "Rob x Kerstin x Nick x Sue";

        String[] splitString = names.split(" x ");

        System.out.println(Arrays.toString(splitString));
        System.out.println();

        String river = "Mississippi";
        String subRiver = river.substring(2,5);

        System.out.println(subRiver);
        System.out.println();

        // Regex
        Pattern p = Pattern.compile("Mi(.*?)pi");
        Matcher m = p.matcher(river);

        while (m.find()) {
            System.out.println(m.group(1));
        }

        String sourceUrl = "";
    }
}
