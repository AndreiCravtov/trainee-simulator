package com.sparta.main.model.waitlist.newtrainee;

import com.sparta.main.model.Trainee;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class NewTraineeWaitingList implements WaitingList {

    public BlockingQueue<Trainee> newTrainingWaitingList;
    private static NewTraineeWaitingList newTraineeInstance;

    private NewTraineeWaitingList() {
        this.newTrainingWaitingList = new LinkedBlockingQueue<>();
    }

    public static NewTraineeWaitingList getInstance() {
        if (newTraineeInstance == null)
            newTraineeInstance = new NewTraineeWaitingList();
        return newTraineeInstance;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        return newTrainingWaitingList.offer(trainee);
    }

    @Override
    public Trainee getFirstInQueue() {
        if (newTrainingWaitingList.size() == 0) {
            return null;
        }
        return newTrainingWaitingList.poll();
    }

    @Override
    public BlockingQueue<Trainee> getWaitingList() {
        return newTrainingWaitingList;
    }

    @Override
    public int sizeOfWaitingList() {
        return newTrainingWaitingList.size();
    }
}
