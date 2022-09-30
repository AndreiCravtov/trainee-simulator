package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.MonthTime;
import com.sparta.main.model.util.Timeable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TechCentreTest {

    public MonthTime monthTime;
    public Trainee testTrainee;
    public TechCentre techCentre;
    public Timeable timeable;

    @BeforeEach
    void setup() {
        timeable = MonthTime.getInstance();
        monthTime = MonthTime.getInstance();
        testTrainee = new Trainee(monthTime);
        techCentre = new TechCentre(timeable);
    }

    @Test
    @DisplayName("Functional Test 1")
    void test1() {
        for (int i = 0; i < 199; i++) {
            techCentre.addTrainee(testTrainee);
        }
        Assertions.assertFalse(techCentre.isFull());
    }

}