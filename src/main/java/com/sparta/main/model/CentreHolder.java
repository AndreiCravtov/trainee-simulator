package com.sparta.main.model;

import java.util.ArrayList;
import java.util.List;

public class CentreHolder {

    private static CentreHolder instance;
    static List<TrainingCentre> centres = new ArrayList<>();

    public static CentreHolder getInstance() {
        if (instance == null)
            instance = new CentreHolder();
        return instance;
    }

    public void assignTrainees(TrainingCentre trainingCentre) {
        // TrainingCentre tc = class.findAvailableCentre();
        // tc.addTrainee(WaitingList.queue.remove());

        if (trainingCentre != null) {
            WaitingList waitingList = WaitingList.getInstance();
            trainingCentre.getTrainee().add(waitingList.getFirstInQueue());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addToHolder(TrainingCentre trainingCentre) {
        centres.add(trainingCentre);
    }



    public static List<TrainingCentre> getCentres() { return centres; }

    public static void addCentre(TrainingCentre trainingCentre) { centres.add(trainingCentre); }

}