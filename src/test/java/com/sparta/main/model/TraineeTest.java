package com.sparta.main.model;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.MonthTime;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TraineeTest {

    public MonthTime monthTime;

    @BeforeEach
    public void setup() {
        monthTime = MonthTime.getInstance();
    }

    @Test
    public void Trainee_createTrainee_SuccessfullyCreated(){
        Trainee trainee = new Trainee(monthTime);
        Assertions.assertNotNull(trainee);
        Assertions.assertEquals(1,trainee.getId());
    }

    @Test
    public void Trainee_IDIncremented(){
        Trainee trainee = new Trainee(monthTime);
        Assertions.assertNotEquals(1,trainee.getId());
    }

    @Test
    public void Trainee_compareTo(){
        Trainee trainee = new Trainee(monthTime);
        Trainee trainee2 = new Trainee(monthTime);

        Assertions.assertEquals(-1,trainee.compareTo(trainee2));
    }

    @Test
    public void Trainee_compareTo_part2(){
        Trainee trainee = new Trainee(monthTime);
        Trainee trainee2 = new Trainee(monthTime);

        Assertions.assertEquals(1,trainee2.compareTo(trainee));
    }

    @Test
    public void Trainee_compareTo_equals(){
        Trainee trainee = new Trainee(monthTime);

        Assertions.assertEquals(-0,trainee.compareTo(trainee));
    }

    @Test
    public void Trainee_ToString_equals(){
        Trainee trainee = new Trainee(monthTime);

        Assertions.assertFalse(trainee.toString().contains("Data"));
    }

}
