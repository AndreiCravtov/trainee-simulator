package com.sparta.Model;

import java.util.ArrayList;

public class TrainingCentres {
    String centerID;
    String centreInfo;
    ArrayList<Trainees> trainees = new ArrayList<>();

    public String getCenterID() {
        return centerID;
    }

    public String getCentreInfo() {
        return centreInfo;
    }

    public void addTrainee(Trainees trainee){
        trainees.add(trainee);
    }


    public ArrayList<Trainees> getTrainees() {
        return trainees;
    }

}
