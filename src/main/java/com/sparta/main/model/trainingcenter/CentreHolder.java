package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.Trainee;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CentreHolder {
    private static CentreHolder instance;
    private final List<TrainingCentre> centres = new ArrayList<>();

    private final Map<Class<? extends TrainingCentre>, Integer> openCentres = new HashMap<>() {{
        put(Bootcamp.class, 0);
        put(TechCentre.class, 0);
        put(TrainingHub.class, 0);
    }};

    private final Map<Class<? extends TrainingCentre>, Integer> closedCentres = new HashMap<>() {{
        put(Bootcamp.class, 0);
        put(TechCentre.class, 0);
        put(TrainingHub.class, 0);
    }};

    public List<TrainingCentre> getCentres() { return centres; }

    /**
     * Gets the number of open centres of a given type
     * @param centreType the type of open centre
     * @return the number of open centres of that type
     */
    public int getNumOpenCentres(Class<? extends TrainingCentre> centreType) { return openCentres.get(centreType); }

    /**
     * Gets the number of closed centres of a given type
     * @param centreType the type of closed centre
     * @return the number of closed centres of that type
     */
    public int getNumClosedCentres(Class<? extends TrainingCentre> centreType) { return openCentres.get(centreType); }

    /**
     * Gets the number of full open centres of a given type
     * @param centreType the type of full open centre
     * @return the number of full open centres of that type
     */
    public int getNumFullCentres(Class<? extends TrainingCentre> centreType) {
        int fullNum = 0;
        for (TrainingCentre centre: centres)
            if (centre.getClass() == centreType && centre.isFull())
                fullNum++;
        return fullNum;
    }

    /**
     * Gets the number of trainees currently training for a given type of centre
     * @param centreType the type of centre
     * @return the number of trainees currently training for that type of centre
     */
    public int getNumCurrentlyTraining(Class<? extends TrainingCentre> centreType) {
        int currentlyTrainingNum = 0;
        for (TrainingCentre centre: centres)
            if (centre.getClass() == centreType)
                currentlyTrainingNum += centre.getNumTrainees();
        return currentlyTrainingNum;
    }

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
        return centre.getClass() != Bootcamp.class || openCentres.get(Bootcamp.class) < 2;
    }

    public boolean addCentre(TrainingCentre centre) {
        if (!canAddCentre(centre)) return false;
        openCentres.merge(centre.getClass(), 1, Integer::sum);
        return centres.add(centre);
    }

    /**
     * Returns a list of trainees which are ready for bench
     * @return a {@code List} of {@code Trainee}s
     */
    public List<Trainee> getBenchReadyTrainees() {
        List<Trainee> readyForBench = new ArrayList<>();
        for (TrainingCentre centre: centres)
            readyForBench.addAll(centre.getBenchReadyTrainees());
        return readyForBench;
    }

    /**
     * Closes any centres that need to be closed
     * @return a list of trainees that have been displaced
     */
    public List<Trainee> closeCentres() {
        List<Trainee> removed = new ArrayList<>();
        List<Trainee> displaced = new ArrayList<>();

        for (TrainingCentre centre: centres) {
            if (centre.canBeClosed()) {
                centres.remove(centre);
                removed.addAll(centre.getTrainees().stream().peek(Trainee::abortTraining).toList());

                openCentres.merge(centre.getClass(), -1, Integer::sum);
                closedCentres.merge(centre.getClass(), 1, Integer::sum);
            }
        }

        for (Trainee trainee: removed)
            if (assignTrainee(trainee) != null)
                displaced.add(trainee);
        return displaced;
    }
}