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

    private WaitingList() { waitingList = new PriorityBlockingQueue<>(); }

    public BlockingQueue<Trainee> getWaitingList() { return waitingList; }

    public boolean addTrainee(Trainee trainee) { return waitingList.offer(trainee); }

    /**
     * Returns the first trainee on the waiting list.
     * @return returns the first trainee on the waiting list
     * or {@code null} if the list is empty
     */
    public Trainee getFirstInQueue() { return waitingList.poll(); }

    public int sizeOfWaitingList() { return waitingList.size(); }

}
