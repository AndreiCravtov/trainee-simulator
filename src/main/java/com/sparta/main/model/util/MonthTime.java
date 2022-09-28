package com.sparta.main.model.util;

public class MonthTime implements Timeable {
    private static final int GLOBAL_GRACE_PERIOD = 3;
    private static int monthCounter = 0;
    private static MonthTime instance;

    public static MonthTime getInstance() {
        if (instance == null)
            instance = new MonthTime();
        return instance;
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
