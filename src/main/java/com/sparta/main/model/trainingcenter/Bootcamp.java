package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.Timeable;

public class Bootcamp extends TrainingCentre {
    int closedCounter = 0;

    public Bootcamp(int id, Timeable timekeeper) {
        super(id,timekeeper);
    }

    @Override
    public boolean canBeClosed() {
        //increment timer, if it is under 25
        if(!timekeeper.inGlobalGracePeriod() &&
                (timekeeper.getTime() - timeCreated) > LOCAL_GRACE_PERIOD &&
                trainees.size() < 25){
            closedCounter++;
            return closedCounter == 3;
        }
        return false;
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return trainee != null &&
                trainees.size() < 500 &&
                !trainees.contains(trainee);
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        if(!canAdd(trainee)) return false;
        return trainees.add(trainee);
    }
}
