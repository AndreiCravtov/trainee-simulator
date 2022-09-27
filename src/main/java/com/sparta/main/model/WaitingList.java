package com.sparta.main.model;

import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class WaitingList {

    private final BlockingQueue<Trainee> waitingList;
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
        waitingList.add(trainee);
    }

    public Trainee getFirstInQueue() {
        if (waitingList == null || waitingList.size() == 0) {
            return null;
        }
        return waitingList.poll();
    }

    public int sizeOfWaitingList() {
        return waitingList.size();
    }

}
