package com.sparta.main.model;

import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class WaitingList {

    private final BlockingQueue<Trainee> waitingList;
    private static WaitingList instance;

    private WaitingList() {
        this.waitingList = new PriorityBlockingQueue<>();
    }

    public static WaitingList getInstance() {
        if (instance == null)
            instance = new WaitingList();
        return instance;
    }

    public void addTrainee(Trainee trainee) {
        waitingList.offer(trainee);
    }

    public Trainee getFirstInQueue() {
        if (waitingList.size() == 0) {
            return null;
        }
        return waitingList.poll();
    }

    public BlockingQueue<Trainee> getWaitingList() {
        return waitingList;
    }

    public int sizeOfWaitingList() {
        return waitingList.size();
    }

}
