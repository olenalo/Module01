package com.company;

import java.util.Random;



public class Train {

    String departurePlace;  // city name
    String destinationPlace;  // city name
    Carriage locomotive;
    Carriage[] passengerFirstClassCarriages;
    Carriage[] passengerSecondClassCarriages;
    Carriage[] cargoCarriages;

    // TODO avoid this (use a different structure?)
//    int currentIndexPassengerFirstClass;
//    int currentIndexPassengerSecondClass;
//    int currentIndexCargo;

    public Train(
            int passengerFirstClassCarriagesNumber,
            int passengerSecondClassCarriagesNumber,
            int cargoCarriagesNumber) {
        this.locomotive = new Carriage("locomotive"); // Always present
        this.passengerFirstClassCarriages = new Carriage[passengerFirstClassCarriagesNumber];
        this.passengerSecondClassCarriages = new Carriage[passengerSecondClassCarriagesNumber];
        this.cargoCarriages = new Carriage[cargoCarriagesNumber];

        // this.currentIndexPassengerFirstClass = 0;
        // this.currentIndexPassengerSecondClass = 0;
        // this.currentIndexCargo = 0;

        // Now add carriages
        if (passengerFirstClassCarriagesNumber > 0) {
            for (int i = 0; i < passengerFirstClassCarriagesNumber; i++) {
                this.addCarriage(new Carriage("passenger class 1"), i);
            }
        }
        // TODO passengerSecondClassCarriages
        // TODO cargoCarriages

    }

    @Override
    public String toString(){
        return "Train goes from " + this.departurePlace + " to " + this.destinationPlace  + "\n" +
                "Train scheme: " + this.passengerFirstClassCarriages[0]; // TODO update train scheme
    }

    public void addCarriage(Carriage carriage, int index) {
        if (carriage.type.equals("passenger class 1")) {
            this.passengerFirstClassCarriages[index] = carriage;
            // this.currentIndexPassengerFirstClass++;
        } else if (carriage.type.equals("passenger class 3")) {
            this.passengerSecondClassCarriages[index] = carriage;
            // this.currentIndexPassengerSecondClass++;
        } else if (carriage.type.equals("cargo")) {
            this.cargoCarriages[index] = carriage;
            // this.currentIndexCargo++;
        }
    }

    public void setItinerary(String departurePlace, String destinationPlace) {
        this.departurePlace = departurePlace;
        this.destinationPlace = destinationPlace;
    }

    public static class Carriage {
        int load; // either percentage or places number
        // TODO: consider type - could be dedicated classes
        String type; // either of: "locomotive", "cargo", "passenger class 1", or "passenger class 2".

        public Carriage(String type) {
            this.type = type;
            this.load = this.generateRandomLoad();
        }

        @Override
        public String toString() {
            return this.type; // TODO add load
        }

        public int generateRandomLoad() {
            int bound = 100;
            if (this.type == "cargo") {
                bound = 100; // it's actually percentage
            } else if (this.type == "passenger class 1") {
                bound = 100;
            } else if (this.type == "passenger class 2") {
                bound = 200;
            } else if (this.type == "locomotive") { // Ccould be `else`, but wanna make it explicit
                bound = 1; // Doesn't apply for locomotive, but bound must be positive... TODO: consider refactoring
            }
            return new Random().nextInt(bound);
        }

    }


    public static void main(String[] args) {
        Train train = new Train(1, 1, 1);
        train.setItinerary("Kharkiv", "Kyiv");
        System.out.println(train);

        Carriage sampleCarriage = new Carriage("cargo");
        System.out.println(sampleCarriage);

    }
}
