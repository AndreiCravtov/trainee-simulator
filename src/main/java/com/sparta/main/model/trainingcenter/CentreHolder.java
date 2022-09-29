package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;
import java.util.ArrayList;
import java.util.List;

public class CentreHolder {
    private static CentreHolder instance;
    private final List<TrainingCentre> centres = new ArrayList<>();
    private int removedCentres;

    public List<TrainingCentre> getCentres() { return centres; }
    public int getRemovedCentres() { return removedCentres; }

    public static CentreHolder getInstance() {
        if (instance == null)
            instance = new CentreHolder();
        return instance;
    }

    public Trainee assignTrainee(Trainee trainee) {
        for (TrainingCentre centre: centres)
            if (centre.addTrainee(trainee))
                return null;
        return trainee;
    }

    public boolean canAddCentre(TrainingCentre centre) {
        return centre != null;
    }

    public boolean addCentre(TrainingCentre centre) {
        if (!canAddCentre(centre)) return false;
        return centres.add(centre);
    }

    public void closeCentre() {
        for (TrainingCentre tc: centres) {
            if (tc.canBeClosed()) {
                centres.remove(tc);
                removedCentres++;
            }
        }
    }
}