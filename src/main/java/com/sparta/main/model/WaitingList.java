package com.sparta.main.model;

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

    private WaitingList() { this.waitingList = new PriorityBlockingQueue<>(); }

    public void addTrainee(Trainee trainee) { waitingList.offer(trainee); }

    /**
     * Returns the fist trainee in the waiting list.
     * @return the first trainee, if list not empty
     * {@code null} if list is empty
     */
    public Trainee getFirstInQueue() { return waitingList.poll(); }

    public BlockingQueue<Trainee> getWaitingList() { return waitingList; }

    public int sizeOfWaitingList() { return waitingList.size(); }

}
