package com.sparta.main.model.util;

import com.sparta.main.model.Timeable;

public class MonthTime implements Timeable {

    private static int monthCounter = 0;
    private final int GRACE_PERIOD = 3;
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
    public boolean isGracePeriod() {
        if (monthCounter < GRACE_PERIOD) {
            return true;
        }
        return false;
    }

    @Override
    public void resetMonthCount() {
        monthCounter = 0;
    }

    public int currentMonth() {
        return monthCounter;
    }

    public int incrementMonth() {
        return monthCounter++;
    }
}
