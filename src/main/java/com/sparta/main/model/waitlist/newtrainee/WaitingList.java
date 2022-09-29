package com.sparta.main.model.waitlist.newtrainee;

import com.sparta.main.model.Trainee;

import java.util.concurrent.BlockingQueue;

public interface WaitingList {

    public boolean addTrainee(Trainee trainee);

    /**
     * Returns the fist trainee in the waiting list.
     * @return the first trainee, if list not empty <br>
     * {@code null}, if list is empty
     */
    public Trainee getFirstInQueue();

    public BlockingQueue<Trainee> getWaitingList();

    public int sizeOfWaitingList();
}
