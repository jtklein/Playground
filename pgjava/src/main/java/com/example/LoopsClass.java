package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannesklein on 19.11.16.
 */

public class LoopsClass {

    public static void main(String[] args) {

        String[] test = {"Test", "Test", "Test", "Test",};
        List<String> array = new ArrayList<String>();

        int count = 0;
        while (count < test.length){
            array.add(test[count]);
            count++;
        }

        for (String item : array){
            System.out.println(item);
        }
        System.out.println();

        // Triangular numbers
        int base = 0;

        for (int i = 0; i < 10; i++){

            base = base + i;
            System.out.println(base);

        }

        //
    }
}
