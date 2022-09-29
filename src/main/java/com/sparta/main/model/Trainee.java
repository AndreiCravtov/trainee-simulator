package com.sparta.main.model;

import com.sparta.main.model.util.Timeable;
import org.jetbrains.annotations.NotNull;

public class Trainee implements Comparable<Trainee> {
    private static int idCount = 0;

    private final Timeable timekeeper;
    private final int traineeId;
    private final Course course;

    private int trainingStart = -1;

    public int getId() { return traineeId; }

    public Course getCourse() { return course; }

    public boolean isTraining() { return trainingStart != -1; }
    public void abortTraining() { trainingStart = -1; }

    public Trainee(Timeable timekeeper) {
        this.timekeeper = timekeeper;
        traineeId = idCount++;
        course = Course.getRandomCourse();
    }

    public void startTraining() { trainingStart = timekeeper.getTime(); }

    public boolean readyForBench() { return timekeeper.getTime() - trainingStart > 3; }

    /**
     * This method serializes the trainee object.
     * It turns the fields in the trainee object into a string.
     * @return the string representation of the trainee object
     */
    @Override
    public String toString() { return String.format("Trainee( ID: %s, Course name: %s )", traineeId, course.getName()); }

    /**
     * Indicates whether some Trainee is "equal to" this one.
     *
     * @param obj the reference Trainee with which to compare.
     * @return {@code true} if this object is the same as the obj argument;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        final Trainee trainee = (Trainee) obj;
        return traineeId == trainee.getId() &&
                course == trainee.course;
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
        hash = 53 * hash + traineeId;
        hash = 53 * hash + course.hashCode();
        return hash;
    }

    @Override
    public int compareTo(@NotNull Trainee trainee) {
        return Integer.compare(traineeId, trainee.traineeId);
    }
}
