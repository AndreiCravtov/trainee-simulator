package com.sparta.main.model;

import org.jetbrains.annotations.NotNull;

public class Trainee {
    private final int traineeId;
    private final Course course;

    public int getId() { return traineeId; }

    public Course getCourse() { return course; }

    public Trainee (int id, @NotNull Course course) {
        this.traineeId = id;
        this.course = course;
    }
}
