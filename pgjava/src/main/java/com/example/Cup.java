package com.example;

/**
 * Created by johannesklein on 17.11.16.
 */

public class Cup {

    String color;

    char initialOne;
    char initialTwo;

    int noHandles;

    double height;
    double diameterTop;
    double diameterBottom;

    public Cup() {
    }

    public Cup(String color, char initialOne, char initialTwo, int noHandles, double height, double diameterTop, double diameterBottom) {
        this.color = color;
        this.initialOne = initialOne;
        this.initialTwo = initialTwo;
        this.noHandles = noHandles;
        this.height = height;
        this.diameterTop = diameterTop;
        this.diameterBottom = diameterBottom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getInitialOne() {
        return initialOne;
    }

    public void setInitialOne(char initialOne) {
        this.initialOne = initialOne;
    }

    public char getInitialTwo() {
        return initialTwo;
    }

    public void setInitialTwo(char initialTwo) {
        this.initialTwo = initialTwo;
    }

    public int getNoHandles() {
        return noHandles;
    }

    public void setNoHandles(int noHandles) {
        this.noHandles = noHandles;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameterTop() {
        return diameterTop;
    }

    public void setDiameterTop(double diameterTop) {
        this.diameterTop = diameterTop;
    }

    public double getDiameterBottom() {
        return diameterBottom;
    }

    public void setDiameterBottom(double diameterBottom) {
        this.diameterBottom = diameterBottom;
    }

    public double getRadiusTop() {

        return diameterTop * 0.5;
    }

    public double getRadiusBottom() {

        return diameterBottom * 0.5;
    }

    public double getVolumeCup() {

        double volumeCup = 0;
        double radiusTop = getRadiusTop();
        double radiusBottom = getRadiusBottom();

        volumeCup = radiusTop * radiusBottom;

        volumeCup = volumeCup + radiusTop * radiusTop + radiusBottom * radiusBottom;

        double part = height * Math.PI * 0.33333333;

        volumeCup = volumeCup * part;

        return volumeCup;
    }
}
