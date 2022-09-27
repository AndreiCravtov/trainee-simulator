package com.sparta.main.model;

import java.util.ArrayList;

public class CentreHolder {

    static ArrayList<TrainingCentre> centres = new ArrayList<>();

    public void assignTrainees(TrainingCentre trainingCentre) {
        // TrainingCentre tc = class.findAvalaibleCentre();
        // tc.addTrainee(WaitingList.queue.remove());

        WaitingList waitingList = WaitingList.getInstance();
        trainingCentre.addTrainee(waitingList.getWaitingList().remove());
    }

    public static ArrayList<TrainingCentre> getCentres() {
        return centres;
    }


    public static void addCentre(TrainingCentre trainingCentre) {
        centres.add(trainingCentre);
    }

}
