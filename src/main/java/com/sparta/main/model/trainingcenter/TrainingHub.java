package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.util.Timeable;
import com.sparta.main.model.Trainee;

public class TrainingHub extends TrainingCentre {
    public TrainingHub(Timeable timeable) {
        super(timeable);
    }

    @Override
    public boolean canBeClosed() {
        return !timekeeper.inGlobalGracePeriod() &&
                (timekeeper.getTime() - timeCreated) > LOCAL_GRACE_PERIOD &&
                trainees.size() < 25;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                trainees.size() < 100 &&
                !trainees.contains(trainee);
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if (!canAdd(trainee)) return false;
        trainee.startTraining();
        return trainees.add(trainee);
    }
}
