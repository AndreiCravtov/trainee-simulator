package com.sparta.main.model.client;


import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.LinearRandom;

import java.util.ArrayList;
import java.util.List;


public class Client {
    final Course traineeType;
    final int traineesRequired;
    List<Trainee> assignedClients = new ArrayList<>();
    boolean happy = false;


    public Client() {
        this.traineeType = Course.getRandomCourse();
        this.traineesRequired = LinearRandom.nextInt(15, 100, 30, 5);
        // put a distribution for the client size requirement
    }

    public Course getTraineeType() {
        return traineeType;
    }

    public int getTraineesRequired() {
        return traineesRequired;
    }

    public boolean isHappy() {
        if (assignedClients.size() > this.traineesRequired) {
            this.happy = true;
        } else  {
            this.happy = false;
        }
        return happy;
    }

    public void addTrainee(Trainee trainee) { this.assignedClients.add(trainee); }

}
