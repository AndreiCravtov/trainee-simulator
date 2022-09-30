package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.Timeable;
public class TechCentre extends TrainingCentre {
    private final Course course;

    public Course getCourse() { return course; }

    public TechCentre(Timeable timekeeper) {
        super(timekeeper);
        course = Course.getRandomCourse();
    }

    @Override
    public boolean isFull() { return trainees.size() >= 200; }

    @Override
    public boolean canBeClosed() {
        return !timekeeper.inGlobalGracePeriod() &&
                (timekeeper.getTime() - timeCreated) > LOCAL_GRACE_PERIOD &&
                trainees.size() < 25;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                course == trainee.getCourse() &&
                !isFull() &&
                !trainees.contains(trainee);
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return false;
        trainee.startTraining();
        return trainees.add(trainee);
    }
}
