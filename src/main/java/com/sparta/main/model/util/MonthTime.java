package com.sparta.main.model.util;

public class MonthTime implements Timeable {

    private static int monthCounter = 0;
    private final int GLOBAL_GRACE_PERIOD = 3;
    private static MonthTime theTimeInstance;

    public static MonthTime getMonthlyInstance() {
        if (theTimeInstance == null) {
            theTimeInstance = new MonthTime();
        }
        return theTimeInstance;
    }

    @Override
    public int getTime() {
        return currentMonth();
    }

    @Override
    public void tick() {
        incrementMonth();
    }

    @Override
    public boolean inGlobalGracePeriod() {
        return monthCounter <= GLOBAL_GRACE_PERIOD;
    }

    @Override
    public void resetTime() {
        monthCounter = 0;
    }

    public int currentMonth() {
        return monthCounter;
    }

    public int incrementMonth() {
        return monthCounter++;
    }
}
