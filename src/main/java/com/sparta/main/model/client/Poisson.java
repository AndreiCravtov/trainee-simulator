package com.sparta.main.model.client;

import java.util.Random;

public class Poisson {
     static int getPoissonRandom(double mean) {
        Random random = new Random();
        double L = Math.exp(-mean);
        int sum = 0;
        double n_x = 1.0;
        do {
            n_x = n_x * random.nextDouble();  // essentially, a sum of n1 * n2 ... * n(n) < L, which means 1/mean -(ln(n1) + ln(n2) ...) < 1
                                              // this works backwards on the lambda^x * e^(-lambda) * 1/x! formula
            sum++;
        } while (n_x > L);
        return sum - 1;
    }
}
