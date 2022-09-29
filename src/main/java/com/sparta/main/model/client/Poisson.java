package com.sparta.main.model.client;

import java.util.Random;

public class Poisson {
     static int getPoissonRandom(double mean) {
        Random random = new Random();
        double L = Math.exp(-mean);
        int sum = 0;
        double n_x = 1.0;
        do {
            n_x = n_x * random.nextDouble();
            sum++;
        } while (n_x > L);
        return sum - 1;
    }
}
