package model.util;

import com.sparta.main.model.util.MonthTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonthTimeTests {

    public MonthTime testTimeable;

    @BeforeEach
    public void setup() {
        testTimeable = MonthTime.getMonthlyInstance();
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
        Assertions.assertTrue(testTimeable.isGlobalGracePeriod());
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
        Assertions.assertFalse(testTimeable.isGlobalGracePeriod());
    }

    @AfterEach
    public void setdown() {
        testTimeable.resetTime();
    }
}
