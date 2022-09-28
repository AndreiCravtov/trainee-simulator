package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;

public class TechCentre extends TrainingCentre {
    private final Course course;

    public Course getCourse() { return course; }

    public TechCentre(int centerID) {
        super(centerID);
        course = Course.getRandomCourse();
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        // if full
        if (course != trainee.getCourse()) return false;
        return true;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return false;
        // Do some more checks
        return true;
    }
}
