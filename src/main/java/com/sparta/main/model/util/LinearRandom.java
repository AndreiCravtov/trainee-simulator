package com.sparta.main.model.util;

import java.util.*;

public class LinearRandom {
    private static Random random = new Random();

    /**
     * Returns a pseudorandomly chosen {@code int} value between the
     * specified {@code lower} and {@code higher} bounds (inclusive).
     * The chosen {@code int} is linearly distributed towards a {@code bias}.
     * The {@code bias} must fall in between the {@code lower} and {@code upper}.
     * If it falls outside the range, it clips back to the respective edge of the range.
     * The value of {@code skew} must be at least 1. If it isn't, it will default to 1.
     *
     * @param lower the least value that can be returned
     * @param higher the most value that can be returned
     * @param bias the random numbers generated tend towards this number
     * @param skew the amount by which random numbers tend towards the {@code bias}. For a uniform distribution, {@code skew = 1}
     * @return a pseudorandomly chosen {@code int} value between the
     * {@code lower} and {@code higher} bounds (inclusive).
     */
     public static int nextInt(int lower, int higher, int bias, int skew) {
         // make sure parameters are appropriate
         if (lower > higher)
             higher = lower;
         if (bias < lower)
             bias = lower;
         if (bias > higher)
             bias = higher;
         if (skew < 1)
             skew = 1;

         Map<Integer, Integer> rand = new HashMap<>();
         for (int i=0; i<skew; i++) {
             int randVal = random.nextInt(lower, higher+1);
             int distVal = Math.abs(bias - randVal);
             rand.put(distVal, randVal);
         }
         return rand.get(Collections.min(rand.keySet()));
    }
}
