package com.sparta.main.model;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class WaitingList {

    private final BlockingDeque<Trainee> waitingList;
    private static WaitingList instance;

    private WaitingList() {
        this.waitingList = new LinkedBlockingDeque<>();
    }

    public static WaitingList getInstance() {
        if (instance == null)
            instance = new WaitingList();
        return instance;
    }

    public boolean addTraineeAtEnd(Trainee trainee) {
        return waitingList.offer(trainee);
    }

    public boolean addTraineeAtStart(Trainee trainee) {
        return waitingList.offerFirst(trainee);
    }

    /**
     * Returns the fist trainee in the waiting list.
     * @return the first trainee, if list not empty <br>
     * {@code null}, if list is empty
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
