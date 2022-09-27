package com.sparta.main.model;

import java.util.ArrayList;

public class TrainingCentre {
    private final int centerID;
    ArrayList<Trainee> newTrainee = new ArrayList<>();

    public TrainingCentre(int centerID) {
        this.centerID = centerID;
    }

    public void addTrainee(Trainee trainee){
        if (newTrainee.size() < 100) {
            newTrainee.add(trainee);
        }
    }

    public int getCenterID() {
        return centerID;
    }

    public ArrayList<Trainee> getTrainee() {
        return newTrainee;
    }
}
