package com.company;

public class Demo {

    public static void main(String[] args) {
        Train train = new Train(2, 1, 3);
        train.setItinerary("Kharkiv", "Kyiv");
        System.out.println(train);

        /*
        Carriage sampleCarriage = new Carriage("cargo");
        System.out.println(sampleCarriage);

        for (Carriage carr: train.passengerSecondClassCarriages) {
            System.out.println(carr);
        }
        */
    }
}
