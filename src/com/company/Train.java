package com.company;

public class Train {
    String departurePlace;  // city name
    String destinationPlace;  // city name
    Carriage locomotive;
    Carriage[] carriages;
    int passengerFirstClassCarriagesNumber;
    int passengerSecondClassCarriagesNumber;
    int cargoCarriagesNumber;

    public Train(
            int passengerFirstClassCarriagesNumber,
            int passengerSecondClassCarriagesNumber,
            int cargoCarriagesNumber) {
        // TODO: check (numbers must be non-negative)
        this.locomotive = new LocomotiveCarriage(); // Always present
        this.carriages = new Carriage[passengerFirstClassCarriagesNumber + passengerSecondClassCarriagesNumber + cargoCarriagesNumber];
        this.passengerFirstClassCarriagesNumber = passengerFirstClassCarriagesNumber;
        this.passengerSecondClassCarriagesNumber = passengerSecondClassCarriagesNumber;
        this.cargoCarriagesNumber = cargoCarriagesNumber;
    }

    @Override
    public String toString(){
        return "Train goes from " + this.departurePlace + " to " + this.destinationPlace  + "\n" +
                "Train scheme: " + this.describeTrainScheme();
    }

    public String updateDescription(String trainSchemeDescription) {
        for (int i = 0; i < this.carriages.length; i++) {
            if (this.carriages[i] != null) {
                trainSchemeDescription += this.carriages[i];
                // No trail for the last carriage
                if (i != this.carriages.length - 1) {
                    trainSchemeDescription += "=";
                }
            }
        }
        return trainSchemeDescription;
    }

    public String describeTrainScheme() {
        return updateDescription(this.locomotive + "=");
    }

    public void addCarriages() {
        int index = 0;

        // Assume the order never changes (2nd pass -> 1st pass -> cargo, as per sample display)
        if (this.passengerSecondClassCarriagesNumber > 0) {
            for (int i = index; i < this.passengerSecondClassCarriagesNumber; i++) {
                this.carriages[i] = new PassengerSecondClassTitleCarriage();
            }
            index += this.passengerSecondClassCarriagesNumber;
        }
        if (this.passengerFirstClassCarriagesNumber > 0) {
            for (int i = index; i < index + this.passengerFirstClassCarriagesNumber; i++) {
                this.carriages[i] = new PassengerFirstClassCarriage();
            }
            index += this.passengerFirstClassCarriagesNumber;
        }
        if (this.cargoCarriagesNumber > 0) {
            for (int i = index; i < index + this.cargoCarriagesNumber; i++) {
                this.carriages[i] = new CargoCarriage();
            }
        }
    }

    public void setItinerary(String departurePlace, String destinationPlace) {
        // TODO: cities must be different
        this.departurePlace = departurePlace;
        this.destinationPlace = destinationPlace;
    }

}
