package com.sparta.main.model.client;


import java.util.Random;

public class Client {

    String traineeType;
    final int traineesRequired;

    public Client() {
        Random random = new Random();
        this.traineesRequired = random.nextInt(15, 100);
    }

    public void makeRequirements() {

    }
}
