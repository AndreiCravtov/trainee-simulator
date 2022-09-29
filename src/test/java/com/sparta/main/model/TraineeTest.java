package com.sparta.main.model;

import com.sparta.main.model.Trainee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TraineeTest {

    @Test
    public void Trainee_createTrainee_SuccessfullyCreated(){
        Trainee trainee = new Trainee();
        Assertions.assertNotNull(trainee);
        Assertions.assertEquals(1,trainee.getId());
    }

    @Test
    public void Trainee_IDIncremented(){
        Trainee trainee = new Trainee();
        Assertions.assertNotEquals(1,trainee.getId());
    }

    @Test
    public void Trainee_compareTo(){
        Trainee trainee = new Trainee();
        Trainee trainee2 = new Trainee();

        Assertions.assertEquals(-1,trainee.compareTo(trainee2));
    }

    @Test
    public void Trainee_compareTo_part2(){
        Trainee trainee = new Trainee();
        Trainee trainee2 = new Trainee();

        Assertions.assertEquals(1,trainee2.compareTo(trainee));
    }

    @Test
    public void Trainee_compareTo_equals(){
        Trainee trainee = new Trainee();

        Assertions.assertEquals(-0,trainee.compareTo(trainee));
    }

    @Test
    public void Trainee_ToString_equals(){
        Trainee trainee = new Trainee();

        Assertions.assertFalse(trainee.toString().contains("Data"));
    }

}
