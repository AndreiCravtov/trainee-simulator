package com.sparta.main.model.waitlist.posttraining;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class ReassignWaitingList extends PostTraining {

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

    public boolean addReassignTrainee(Trainee trainee) {
        return addTrainee(reassignWaitingList,trainee);
    };

    public Trainee getFirstReassignTraineeByType(Course type) {
        return getFirstTraineeByType(reassignWaitingList, type);
    };

    public Trainee getFirstReassignTrainee() {
        return getFirstTrainee(reassignWaitingList);
    }

    public List<Trainee> getReassignWaitingList() {
        return getWaitingList(reassignWaitingList);
    };

    public int sizeOfReassignWaitingList() {
        return sizeOfWaitingList(reassignWaitingList);
    };

    public int numberOfReassignedTraineeOfType(Course type) {
        return numberOfTraineeOfType(reassignWaitingList, type);
    };

    public boolean removeReassignedTrainee(Trainee trainee) {
        return removeTrainee(reassignWaitingList,trainee);
    }
}
