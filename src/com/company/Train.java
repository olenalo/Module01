package com.company;

import java.util.Random;



public class Train {

    static final String locomotiveClassTitle = "locomotive";
    static final String passengerFirstClassTitle = "passenger class 1";
    static final String passengerSecondClassTitle = "passenger class 2";
    static final String cargoTitle = "cargo";

    String departurePlace;  // city name
    String destinationPlace;  // city name
    Carriage locomotive;
    // Creating separate arrays, each of them will have different types (per carriage type)
    Carriage[] passengerFirstClassCarriages;
    Carriage[] passengerSecondClassCarriages;
    Carriage[] cargoCarriages;

    public Train(
            int passengerFirstClassCarriagesNumber,
            int passengerSecondClassCarriagesNumber,
            int cargoCarriagesNumber) {
        this.locomotive = new Carriage(Train.locomotiveClassTitle); // Always present
        this.passengerFirstClassCarriages = new Carriage[passengerFirstClassCarriagesNumber];
        this.passengerSecondClassCarriages = new Carriage[passengerSecondClassCarriagesNumber];
        this.cargoCarriages = new Carriage[cargoCarriagesNumber];

        // Now add carriages
        this.addCarriages(Train.passengerFirstClassTitle, passengerFirstClassCarriagesNumber);
        this.addCarriages(Train.passengerSecondClassTitle, passengerSecondClassCarriagesNumber);
        this.addCarriages(Train.cargoTitle, cargoCarriagesNumber);
    }

    @Override
    public String toString(){
        return "Train goes from " + this.departurePlace + " to " + this.destinationPlace  + "\n" +
                "Train scheme: " + this.desribeTrainScheme();
    }

    public String desribeTrainScheme() {
        String trainSchemeDescr = this.locomotive + "=";  // TODO locomotive starts with "<:"

        // Let 2nd class go first
        for (Carriage carriage: this.passengerSecondClassCarriages) {
            if (carriage != null) {
                trainSchemeDescr += carriage + "=";
            }
        }
        // TODO: DRY
        for (Carriage carriage: this.passengerFirstClassCarriages) {
            if (carriage != null) {
                trainSchemeDescr += carriage + "=";
            }
        }
        for (Carriage carriage: this.cargoCarriages) {
            if (carriage != null) {
                trainSchemeDescr += carriage + "="; // TODO: remove the last "="
            }
        }

        return trainSchemeDescr;
    }

    public void addCarriage(Carriage carriage, int index) {
        if (carriage.type.equals(Train.passengerFirstClassTitle)) {
            this.passengerFirstClassCarriages[index] = carriage;
        } else if (carriage.type.equals(Train.passengerSecondClassTitle)) {
            this.passengerSecondClassCarriages[index] = carriage;
        } else if (carriage.type.equals(Train.cargoTitle)) {
            this.cargoCarriages[index] = carriage;
        }
    }

    public void addCarriages(String type, int carriagesNumber) {
        if (carriagesNumber > 0) { // TODO: get from field, when arrays are replaced with smth else
            for (int i = 0; i < carriagesNumber; i++) {
                this.addCarriage(new Carriage(type), i);
            }
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
            String loadFormat = ""; // Will apply for locomotive
            if (this.type.equals(Train.cargoTitle)) {
                loadFormat = this.load + "%";
            } else if (this.type.equals(Train.passengerFirstClassTitle) || this.type.equals(Train.passengerSecondClassTitle)) {
                loadFormat = "1:" + this.load;
            }
            return "[:" + this.type + ":" + loadFormat +  "]";
        }

        public int generateRandomLoad() {
            int bound = 100;
            if (this.type == Train.cargoTitle) {
                bound = 100; // it's actually percentage
            } else if (this.type.equals(Train.passengerFirstClassTitle)) {
                bound = 100;
            } else if (this.type.equals(Train.passengerSecondClassTitle)) {
                bound = 200;
            } else if (this.type.equals(Train.locomotiveClassTitle)) { // Could be `else`, but wanna make it explicit
                bound = 1; // Doesn't apply for locomotive, but bound must be positive... TODO: consider refactoring
            }
            return new Random().nextInt(bound);
        }

    }


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
