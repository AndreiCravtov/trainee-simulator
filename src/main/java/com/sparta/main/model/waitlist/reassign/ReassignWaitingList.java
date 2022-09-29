package com.sparta.main.model.waitlist.reassign;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class ReassignWaitingList  {

    private List<Trainee> reassignWaitingList;
    private static ReassignWaitingList reassignWaitingListInstance;

    private ReassignWaitingList() {
        reassignWaitingList = new ArrayList<Trainee>();
    }

    public static ReassignWaitingList getInstance() {
        if (reassignWaitingListInstance == null) {
            reassignWaitingListInstance = new ReassignWaitingList();
        }
        return reassignWaitingListInstance;
    }

    public boolean addTrainee(Trainee trainee) {
        return reassignWaitingList.add(trainee);
    };

    public Trainee getFirstTraineeByType(Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        Trainee foundTrainee = reassignWaitingList.stream()
                .filter(x -> x.getCourse() == type)
                .findFirst()
                .get();
        return foundTrainee;
    };

    public Trainee getFirstTrainee() {
        return reassignWaitingList.get(0);
    }

    public List<Trainee> getWaitingList() {
        return reassignWaitingList;
    };

    public int sizeOfWaitingList() {
        return reassignWaitingList.size();
    };

    public int numberOfTraineeOfType(Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        int count = (int) reassignWaitingList.stream()
                .filter(x -> x.getCourse() == type)
                .count();
        return count;
    };
}
