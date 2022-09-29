package com.sparta.main.model.client;


import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.LinearRandom;
import com.sparta.main.model.util.Timeable;

import java.util.ArrayList;
import java.util.List;


public class Client {
    private final Timeable timekeeper;
    private int yearStart;
    private final Course course;
    private final int traineesRequired;
    private final List<Trainee> assignedTrainees;

    public Course getCourse() { return course; }

    public int getTraineesRequired() { return traineesRequired; }

    public Client(Timeable timekeeper) {
        this.timekeeper = timekeeper;
        yearStart = timekeeper.getTime();
        course = Course.getRandomCourse();
        traineesRequired = LinearRandom.nextInt(15, 100, 30, 3);
        assignedTrainees = new ArrayList<>();
    }

    public boolean isUnhappy() {
        int elapsed = timekeeper.getTime() - yearStart;

        if (elapsed < 12) return false;
        if  (elapsed == 12 && assignedTrainees.size() == traineesRequired) { // if happy, restart year
            yearStart = timekeeper.getTime();
            assignedTrainees.clear();
            return false;
        }
        return true;
    }

    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                course == trainee.getCourse() &&
                assignedTrainees.size() < traineesRequired;
    }

    public Trainee addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return trainee;
        assignedTrainees.add(trainee);
        return null;
    }

}
