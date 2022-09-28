package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Timeable;
import com.sparta.main.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public abstract class TrainingCentre implements Timeable {
    protected static int GRACE_PERIOD = 1;
    protected final int id;
    protected int time;
    protected final List<Trainee> trainees;

    public int getId() { return id; }

    @Override
    public int getTime() { return time; }

    public List<Trainee> getTrainees() { return trainees; }

    public TrainingCentre(int centerID) {
        this.id = centerID;
        time = 0;
        trainees = new ArrayList<>();
    }

    @Override
    public void tick() { time++; }

    public abstract boolean canBeClosed();

    public abstract boolean canAdd(Trainee trainee);

    public abstract boolean addTrainee(Trainee trainee);
}
