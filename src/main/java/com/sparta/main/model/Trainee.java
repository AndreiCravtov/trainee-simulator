package com.sparta.main.model;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Trainee {
    public static Trainee createTrainee(){
        Random rand = new Random();
        int x;
        do {
            x = rand.nextInt(100000,1000000);
        } while(x<555555); // Check that an employee with ID doesn't already exist

        Course[] courses = Course.values();
        return new Trainee(x, courses[rand.nextInt(0, courses.length)]);
    }

    private int traineeId;
    private Course course;

    public int getId() {
        return traineeId;
    }

    public Course getCourse() {
        return course;
    }

    public Trainee(int traineeId, @NotNull Course course) {
        this.traineeId = traineeId;
        this.course = course;
    }

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
}
