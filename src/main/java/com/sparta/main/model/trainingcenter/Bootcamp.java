package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;

public class Bootcamp extends TrainingCentre {
    public Bootcamp(int centerID) {
        super(centerID);
    }

    @Override
    public boolean canAdd(Trainee trainee) {
        return false;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        return false;
    }
}
