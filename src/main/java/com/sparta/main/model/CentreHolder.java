package com.sparta.main.model;

import java.util.ArrayList;
import java.util.Arrays;

public class CentreHolder {

    static ArrayList<TrainingCentre> centres = new ArrayList<>();

    public void assignTrainees(TrainingCentre trainingCentre) {
        // TrainingCentre tc = class.findAvalaibleCentre();
        // tc.addTrainee(WaitingList.queue.remove());

        if (trainingCentre != null) {
            WaitingList waitingList = WaitingList.getInstance();
            trainingCentre.newTrainee.add(waitingList.getWaitingList().remove());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String getCentres() {
        return centres.toString();
    }



    public static void addCentre(TrainingCentre trainingCentre) {
        centres.add(trainingCentre);
    }

}
