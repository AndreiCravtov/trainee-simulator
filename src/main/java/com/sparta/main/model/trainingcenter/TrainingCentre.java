package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Timeable;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.MonthTime;

import java.util.ArrayList;
import java.util.List;

public abstract class TrainingCentre {
    protected static int LOCAL_GRACE_PERIOD = 1;
    protected final int id;
    protected Timeable timekeeper;
    protected int timeCreated;
    protected final List<Trainee> trainees;

    public int getId() { return id; }

    public int getTimeCreated() { return timeCreated; }

    public List<Trainee> getTrainees() { return trainees; }

    public TrainingCentre(int id, Timeable timekeeper) {
        this.id = id;
        this.timekeeper = timekeeper;
        timeCreated = timekeeper.getTime();
        trainees = new ArrayList<>();
    }

    public TrainingCentre(int id) {
        this.id = id;
        this.timekeeper = MonthTime.getInstance();
        timeCreated = timekeeper.getTime();
        trainees = new ArrayList<>();
    }

    public abstract boolean canBeClosed();

    public abstract boolean canAdd(Trainee trainee);

    public abstract boolean addTrainee(Trainee trainee);
}
