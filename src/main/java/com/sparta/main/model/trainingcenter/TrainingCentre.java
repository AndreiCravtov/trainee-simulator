package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public abstract class TrainingCentre {
    private final int centerID;
    private final List<Trainee> trainees;

    private boolean open;

    public int getCenterID() { return centerID; }

    public List<Trainee> getTrainees() { return trainees; }

    public TrainingCentre(int centerID) {
        this.centerID = centerID;
        trainees = new ArrayList<>();
    }

    public abstract boolean canBeClosed();

    public abstract boolean canAdd(Trainee trainee);

    public abstract boolean addTrainee(Trainee trainee);
}
