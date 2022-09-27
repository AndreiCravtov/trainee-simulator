package com.sparta.main.model;

import java.util.ArrayList;
import java.util.List;

public class CentreHolder {

    static List<TrainingCentre> centres = new ArrayList<>();

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

    public static List<TrainingCentre> getCentres() { return centres; }

    public static void addCentre(TrainingCentre trainingCentre) { centres.add(trainingCentre); }

}
