package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.MonthTime;
import com.sparta.main.model.util.Timeable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BootcampTest {

    public MonthTime monthTime;
    public Trainee testTrainee;
    public Bootcamp bootcamp;
    public Timeable timeable;

    @BeforeEach
    void setup() {
        timeable = MonthTime.getInstance();
        monthTime = MonthTime.getInstance();
        testTrainee = new Trainee(monthTime);
        bootcamp = new Bootcamp(timeable);
    }

    @Test
    @DisplayName("Functional Test 1")
    void test1() {
        for (int i = 0; i < 499; i++) {
            bootcamp.addTrainee(testTrainee);
        }
        Assertions.assertFalse(bootcamp.isFull());

    }

}