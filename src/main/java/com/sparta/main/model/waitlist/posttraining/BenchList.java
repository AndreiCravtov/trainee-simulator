package com.sparta.main.model.waitlist.posttraining;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;

import java.util.ArrayList;
import java.util.List;

public class BenchList extends PostTraining{

    private List<Trainee> benchWaitingList;
    private static BenchList benchListInstance;

    private BenchList() {
        benchWaitingList = new ArrayList<Trainee>();
    }

    public static BenchList getInstance() {
        if (benchListInstance == null) {
            benchListInstance = new BenchList();
        }
        return benchListInstance;
    }

    public boolean addBenchTrainee(Trainee trainee) {
        return addTrainee(benchWaitingList,trainee);
    };

    public Trainee getFirstBenchTraineeByType(Course type) {
        return getFirstTraineeByType(benchWaitingList, type);
    };

    public Trainee getFirstBenchTrainee() {
        return getFirstTrainee(benchWaitingList);
    }

    public List<Trainee> getBenchWaitingList() {
        return getWaitingList(benchWaitingList);
    };

    public int sizeOfBenchWaitingList() {
        return sizeOfWaitingList(benchWaitingList);
    };

    public int numberOfBenchedTraineeOfType(Course type) {
        return numberOfTraineeOfType(benchWaitingList, type);
    };
}
