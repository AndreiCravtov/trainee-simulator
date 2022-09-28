package com.sparta.main.model.util;

public class MonthTime {

    private static int monthCounter = 0;
    private static MonthTime theTimeInstance;

    public MonthTime getMonthlyInstance() {
        if (theTimeInstance == null) {
            theTimeInstance = new MonthTime();
        }
        return theTimeInstance;
    }

    public int currentMonth() {
        return monthCounter;
    }

    public int incrementMonth() {
        return monthCounter++;
    }

    public boolean isGracePeriod() {
        if (monthCounter < 3) {
            return true;
        }
        return false;
    }
}
