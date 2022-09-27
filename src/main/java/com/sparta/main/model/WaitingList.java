package com.sparta.main.model;

import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class WaitingList {

    private static WaitingList instance;

    public static WaitingList getInstance() {
        if (instance == null)
            instance = new WaitingList();
        return instance;
    }

    private final BlockingQueue<Trainee> waitingList;

    private WaitingList() { waitingList = new PriorityBlockingQueue<>(); }

    public BlockingQueue<Trainee> getWaitingList() {
        return waitingList;
    }

    public void addTrainee(Trainee trainee) {
        waitingList.add(trainee);
    }

    public Trainee getFirstInQueue() {
        if (waitingList.size() == 0)
            throw new NoSuchElementException("No trainees in waiting list");
        return waitingList.poll();
    }

    public int sizeOfWaitingList() {
        return waitingList.size();
    }

}
