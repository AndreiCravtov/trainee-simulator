package com.sparta.main.model;

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

    /**
     * Returns the fist trainee in the waiting list.
     * @return the first trainee, if list not empty
     * {@code null} if list is empty
     */
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
