package com.company;

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

}
