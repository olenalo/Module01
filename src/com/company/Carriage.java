package com.company;

import java.util.Random;

public class Carriage {
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
