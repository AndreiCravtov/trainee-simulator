package com.sparta.main.model;

public class Trainee {
    private final int traineeId;
    private final Course course;

    public int getId() { return traineeId; }

    public Course getCourse() { return course; }

    public Trainee (int id, Course course) {
        this.traineeId = id;
        this.course = course;
    }
}
