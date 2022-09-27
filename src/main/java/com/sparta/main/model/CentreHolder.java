package com.sparta.main.model;

import java.util.ArrayList;
import java.util.Queue;

public class CentreHolder {

    ArrayList<TrainingCentre> centres = new ArrayList<>();

    public void assignTrainees(TrainingCentre tc, Queue<Trainee> traineeQueue) {
        tc.addTrainee(traineeQueue.remove());
    }





}
