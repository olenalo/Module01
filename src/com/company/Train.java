package com.company;

public class Train {
    String departurePlace;  // city name
    String destinationPlace;  // city name
    Carriage locomotive;
    Carriage[] passengerFirstClassCarriages;
    Carriage[] passengerSecondClassCarriages;
    Carriage[] cargoCarriages;

    public Train(
            int passengerFirstClassCarriagesNumber,
            int passengerSecondClassCarriagesNumber,
            int cargoCarriagesNumber) {
        // TODO: check (numbers must be non-negative)
        this.locomotive = new LocomotiveCarriage(); // Always present
        this.passengerFirstClassCarriages = new PassengerFirstClassCarriage[passengerFirstClassCarriagesNumber];
        this.passengerSecondClassCarriages = new PassengerSecondClassTitleCarriage[passengerSecondClassCarriagesNumber];
        this.cargoCarriages = new CargoCarriage[cargoCarriagesNumber];
    }

    @Override
    public String toString(){
        return "Train goes from " + this.departurePlace + " to " + this.destinationPlace  + "\n" +
                "Train scheme: " + this.describeTrainScheme();
    }

    public static String updateDescription(String trainSchemeDescr, Carriage[] carriages) {
        for (int i = 0; i < carriages.length; i++) {
            if (carriages[i] != null) {
                trainSchemeDescr += carriages[i];
                // No trail for the last carriage
                if (i != carriages.length - 1) {
                    trainSchemeDescr += "=";
                }
            }
        }
        return trainSchemeDescr;
    }

    public String describeTrainScheme() {
        String trainSchemeDescription = this.locomotive + "=";
        // Let 2nd class go first; assume the order never changes
        trainSchemeDescription = updateDescription(trainSchemeDescription, this.passengerSecondClassCarriages);
        trainSchemeDescription = updateDescription(trainSchemeDescription, this.passengerFirstClassCarriages);
        trainSchemeDescription = updateDescription(trainSchemeDescription, this.cargoCarriages);
        return trainSchemeDescription;
    }

    public void addCarriages() {
        Carriage carriage;
        if (this.passengerFirstClassCarriages.length > 0) {
            for (int i = 0; i < this.passengerFirstClassCarriages.length; i++) {
                carriage = new PassengerFirstClassCarriage();
                this.passengerFirstClassCarriages[i] = carriage;
            }
        }
        if (this.passengerSecondClassCarriages.length > 0) {
            for (int i = 0; i < this.passengerSecondClassCarriages.length; i++) {
                carriage = new PassengerSecondClassTitleCarriage();
                this.passengerSecondClassCarriages[i] = carriage;
            }
        }
        if (this.cargoCarriages.length > 0) {
            for (int i = 0; i < this.cargoCarriages.length; i++) {
                carriage = new CargoCarriage();
                this.cargoCarriages[i] = carriage;
            }
        }
    }

    public void setItinerary(String departurePlace, String destinationPlace) {
        // TODO: cities must be different
        this.departurePlace = departurePlace;
        this.destinationPlace = destinationPlace;
    }

}
