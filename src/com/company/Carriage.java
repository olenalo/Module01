package com.company;

import java.util.Random;

public class Carriage {
    public int load;
    public String type;
    public int maxLoad;

    public int generateRandomLoad() {
        return new Random().nextInt(this.maxLoad); // TODO check that for 2nd class PASS, max is 200
    }
}
