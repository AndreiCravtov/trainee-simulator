package com.sparta.main.model.client;


import com.sparta.main.model.Course;

import java.util.Random;

public class Client {

    String traineeType;
    final int traineesRequired;
    private final Course course;

    public Client(Course course) {
        this.course = course;
        Random random = new Random();
        this.traineesRequired = random.nextInt(15, 100);// may need a reasonable limit
    }

    public void makeRequirements() {

    }
}
