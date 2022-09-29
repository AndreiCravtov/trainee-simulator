package com.sparta.main.model;

import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.newtrainee.WaitingList;
import com.sparta.main.model.trainingcenter.TrainingCentre;
import com.sparta.main.model.waitlist.WaitingListType;

import java.util.ArrayList;
import java.util.List;

public class CentreHolder {
    private static int removedCentres;
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
            WaitingList waitingList = NewTraineeWaitingList.getInstance();
            trainingCentre.getTrainees().add(waitingList.getFirstInQueueByType(WaitingListType.NEWTRAINEE));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addToHolder(TrainingCentre trainingCentre) {
        centres.add(trainingCentre);
    }

    public void closeCentre() {
        for (TrainingCentre tc: centres) {
            if (tc.canBeClosed()) {
                centres.remove(tc);
                removedCentres++;
            }
        }
    }

    public static int getRemovedCentres() { return removedCentres; }

    public static List<TrainingCentre> getCentres() { return centres; }

    public static void addCentre(TrainingCentre trainingCentre) { centres.add(trainingCentre); }

}