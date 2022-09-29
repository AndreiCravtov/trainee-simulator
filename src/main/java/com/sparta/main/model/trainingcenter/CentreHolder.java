package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CentreHolder {
    private static CentreHolder instance;
    private final List<TrainingCentre> centres = new ArrayList<>();
    private int numBootcamp = 0;
    private int removedCentres = 0;

    public List<TrainingCentre> getCentres() { return centres; }

    public int getRemovedCentres() { return removedCentres; }

    public static CentreHolder getInstance() {
        if (instance == null)
            instance = new CentreHolder();
        return instance;
    }

    /**
     * Assigns a trainee to one of the available centres.
     *
     * @param trainee the trainee to be assigned
     * @return {@code null} if the trainee was assigned, <br>
     * the input {@code Trainee} object if not.
     */
    public Trainee assignTrainee(@NotNull Trainee trainee) {
        for (TrainingCentre centre: centres)
            if (centre.addTrainee(trainee))
                return null;
        return trainee;
    }

    public boolean canAddCentre(TrainingCentre centre) {
        if (centre == null) return false;
        return centre.getClass() != Bootcamp.class || numBootcamp < 2;
    }

    public boolean addCentre(TrainingCentre centre) {
        if (!canAddCentre(centre)) return false;
        if (centre.getClass() == Bootcamp.class) numBootcamp++;
        return centres.add(centre);
    }

    /**
     * Closes any centres that need to be closed
     * @return a list of trainees that have been displaced, if there are any <br>
     * {@code null} if there aren't any displaced trainees
     */
    public List<Trainee> closeCentre() {
        List<Trainee> removed = new ArrayList<>();
        List<Trainee> displaced = new ArrayList<>();

        for (TrainingCentre centre: centres) {
            if (centre.canBeClosed()) {
                removed.addAll(centre.getTrainees());
                centres.remove(centre);
                if (centre.getClass() == Bootcamp.class) numBootcamp--;
                removedCentres++;
            }
        }

        for (Trainee trainee: removed)
            if (assignTrainee(trainee) != null)
                displaced.add(trainee);
        if (displaced.size() > 0) return displaced;
        return null;
    }
}