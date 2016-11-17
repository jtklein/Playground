package com.example;

public class MyClass {

    private static Cup mCup = null;

    public static void main(String[] args) {

        System.out.println("Do you want to buy a new cup?");

        buyNewCup();

        System.out.println("Your cup is ordered! It is going o be: ");
        System.out.println(mCup.color + " with " + mCup.initialOne + mCup.initialTwo + " on one side!");

        System.out.println(" It has a volume of: " + mCup.getVolumeCup());


    }

    public static void buyNewCup(){

        mCup = new Cup();

        giveOrder(true);

    }

    private static void giveOrder(boolean branded) {

        mCup.setColor("Red");

        if (branded){
            mCup.setInitialOne('J');
            mCup.setInitialTwo('K');
        }

        mCup.setNoHandles(1);

        mCup.setHeight(1.7);
        mCup.setDiameterBottom(0.9);
        mCup.setDiameterTop(1.2);
    }
}
