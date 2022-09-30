package com.sparta.main.model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class NewTraineeWaitingList extends WaitingList {

    private List<Trainee> newTraineeWaitingList;
    private static NewTraineeWaitingList newTraineeListInstance;

    private NewTraineeWaitingList() {
        newTraineeWaitingList = new ArrayList<Trainee>();
    }

    public static NewTraineeWaitingList getInstance() {
        if (newTraineeListInstance == null) {
            newTraineeListInstance = new NewTraineeWaitingList();
        }
        return newTraineeListInstance;
    }

    public boolean addNewTrainee(Trainee trainee) {
        return addTrainee(newTraineeWaitingList,trainee);
    };

    public Trainee getFirstNewTraineeByType(Course type) {
        return getFirstTraineeByType(newTraineeWaitingList, type);
    };

    public Trainee getFirstNewTrainee() {
        return getFirstTrainee(newTraineeWaitingList);
    }

    public List<Trainee> getNewTraineeWaitingList() {
        return getWaitingList(newTraineeWaitingList);
    };

    public int sizeOfNewTraineeWaitingList() {
        return sizeOfWaitingList(newTraineeWaitingList);
    };

    public int numberOfNewTraineeOfType(Course type) {
        return numberOfTraineeOfType(newTraineeWaitingList, type);
    };

    public Trainee removeNewTrainee(Trainee trainee) {
        if (removeTrainee(newTraineeWaitingList,trainee)) {
            return trainee;
        }
        return null;
    }
}
