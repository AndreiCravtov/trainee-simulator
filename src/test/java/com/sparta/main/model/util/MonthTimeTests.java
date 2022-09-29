package com.sparta.main.model.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonthTimeTests {

    public MonthTime testTimeable;

    @BeforeEach
    public void setup() {
        testTimeable = MonthTime.getInstance();
    }

    @Test
    public void monthTime_InstanceCreated() {
        Assertions.assertNotNull(testTimeable);
    }

    @Test
    public void monthTime_month0() {
        Assertions.assertEquals(0, testTimeable.getTime());
    }

    @Test
    public void monthTime_InGracePeriod_true() {
        Assertions.assertTrue(testTimeable.inGlobalGracePeriod());
    }

    @Test
    public void monthTime_Increment() {
        int startMonth = testTimeable.getTime();
        testTimeable.tick();
        int endMonth = testTimeable.getTime();
        Assertions.assertEquals(startMonth+1, endMonth);
    }

    @Test
    public void monthTime_InGracePeriod_false() {
        for (int i = 0; i < 5; i++) {
            testTimeable.tick();
        }
        Assertions.assertFalse(testTimeable.inGlobalGracePeriod());
    }

    @AfterEach
    public void setdown() {
        testTimeable.resetTime();
    }
}
