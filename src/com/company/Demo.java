package com.company;

public class Demo {

    public static void main(String[] args) {
        Train train = new Train(2, 1, 3);
        train.setItinerary("Kharkiv", "Kyiv");

        train.addCarriages();

        System.out.println(train);
    }
}
