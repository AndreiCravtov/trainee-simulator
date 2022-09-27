package com.sparta.main.model;

import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class WaitingList {

    private BlockingQueue<Trainee> waitingList;
    private static WaitingList trainingWaitingList;

    private WaitingList() {
        this.waitingList = new PriorityBlockingQueue<>();
    }

    public static WaitingList getInstance() {
        if (trainingWaitingList == null) {
            trainingWaitingList = new WaitingList();
        }
        return trainingWaitingList;
    }

    public BlockingQueue<Trainee> getWaitingList() {
        return this.waitingList;
    }

    public void addTrainee(Trainee trainee) {
        if (waitingList == null) {
            getInstance();
        }
        waitingList.add(trainee);
    }

    public Trainee getFirstInQueue() {
        if (waitingList == null || waitingList.size() == 0) {
            throw new NoSuchElementException("No trainees in waiting list");
        }
        return waitingList.poll();
    }

    public int sizeOfWaitingList() {
        return waitingList.size();
    }

}
