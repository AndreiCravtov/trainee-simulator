package com.sparta.main.model;

import java.util.Random;

public class Trainee {
    private int id;
    private String course;

    public static Trainee addTrainee(){
        Random rand = new Random();
        int x;
        do {
             x = rand.nextInt(100000,1000000);
        } while(x<555555); // Check that an employee with ID doesnt already exist

        return new Trainee(x,"Filler Course");
    }

    public Trainee(int id, String course) {
        this.id = id;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }
}
