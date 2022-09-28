package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Course;
import com.sparta.main.model.Timeable;
import com.sparta.main.model.Trainee;

public class TechCentre extends TrainingCentre {
    private final Course course;

    public Course getCourse() { return course; }

    public TechCentre(int id, Timeable timekeeper) {
        super(id, timekeeper);
        course = Course.getRandomCourse();
    }

    @Override
    public boolean canBeClosed() {
        return (timekeeper.getTime() - timeCreated) > LOCAL_GRACE_PERIOD &&
                trainees.size() < 25;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                course == trainee.getCourse() &&
                trainees.size() < 200 &&
                !trainees.contains(trainee);
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return false;
        else if (trainee.getCourse()!=course) return false;
        else return true;
    }
}
