package com.sparta.main.model.client;


import com.sparta.main.model.Trainee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Client {

    Random random = new Random();
    final String traineeType;
    final int traineesRequired;
    List<Trainee> assignedClients = new ArrayList<>();
    boolean happy = false;


    public Client() {
        String[] types = new String[] {"JAVA", "C#", "DEV-OPS", "TESTING", "BUSINESS"};
        this.traineeType = types[random.nextInt(0, types.length - 1)];
        this.traineesRequired = LinearRandom.nextInt(15, 100, 30, 45);
        // put a distribution for the client size requirement
    }

    public String getTraineeType() {
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

    public void addConsultant(Trainee trainee) { this.assignedClients.add(trainee); }

}
