package com.sparta.main.model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;

import java.util.List;

public abstract class WaitingList {

    public boolean addTrainee(List<Trainee> list, Trainee trainee) {
        return list.add(trainee);
    };

    public Trainee getFirstTraineeByType(List<Trainee> list, Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        Trainee foundTrainee = list.stream()
                .filter(x -> x.getCourse() == type)
                .findFirst()
                .get();
        return foundTrainee;
    };

    public boolean removeTrainee(List<Trainee> list, Trainee trainee) {
        return list.remove(trainee);
    }

    public Trainee getFirstTrainee(List<Trainee> list) {
        if (list.size() < 1) return null;
        return list.get(0);
    }

    public List<Trainee> getWaitingList(List<Trainee> list) {
        return list;
    };

    public int sizeOfWaitingList(List<Trainee> list) {
        return list.size();
    };

    public int numberOfTraineeOfType(List<Trainee> list, Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        int count = (int) list.stream()
                .filter(x -> x.getCourse() == type)
                .count();
        return count;
    };
}
