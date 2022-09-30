package com.sparta.main.model.trainingcenter;

import com.sparta.main.model.util.Timeable;
import com.sparta.main.model.Trainee;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class TrainingCentre implements Comparable<TrainingCentre>{
    protected static int LOCAL_GRACE_PERIOD = 1;
    private static int idCount = 0;
    protected final int id;
    protected Timeable timekeeper;
    protected int timeCreated;
    protected final List<Trainee> trainees;

    public int getId() { return id; }

    public int getTimeCreated() { return timeCreated; }

    public List<Trainee> getTrainees() { return trainees; }

    public int getNumTrainees() { return trainees.size(); }

    public TrainingCentre(Timeable timekeeper) {
        this.timekeeper = timekeeper;
        id = idCount++;
        timeCreated = timekeeper.getTime();
        trainees = new ArrayList<>();
    }

    /**
     * Returns a list of trainees which are ready for bench
     * @return a {@code List} of {@code Trainee}s
     */
    public List<Trainee> getBenchReadyTrainees() {
        List<Trainee> readyForBench = new ArrayList<>();
        for (Trainee trainee: trainees)
            if (trainee.readyForBench()) {
                trainees.remove(trainee);
                readyForBench.add(trainee);
            }
        return readyForBench;
    }

    public abstract boolean isFull();

    public abstract boolean canBeClosed();

    public abstract boolean canAdd(Trainee trainee);

    public abstract boolean addTrainee(Trainee trainee);

    /**
     * Indicates whether some TrainingCentre is "equal to" this one.
     *
     * @param obj the reference Trainee with which to compare.
     * @return {@code true} if this object is the same as the obj argument;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        final TrainingCentre centre = (TrainingCentre) obj;
        return id == centre.id &&
                timeCreated == centre.timeCreated &&
                trainees == centre.trainees;
    }

    /**
     * Returns a hash code value for this Trainee. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link java.util.HashMap}.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 821;
        hash = 53 * hash + id;
        hash = 53 * hash + timeCreated;
        hash = 53 * hash + trainees.hashCode();
        return hash;
    }

    @Override
    public int compareTo(@NotNull TrainingCentre centre) {
        return Integer.compare(id, centre.id);
    }
}
