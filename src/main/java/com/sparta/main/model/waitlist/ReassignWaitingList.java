package com.sparta.main.model.waitlist;

import com.sparta.main.model.Trainee;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReassignWaitingList implements WaitingList {

    public BlockingQueue<Trainee> reassignWaitingList;
    private static ReassignWaitingList reassignInstance;

    private ReassignWaitingList() {
        this.reassignWaitingList = new LinkedBlockingQueue<>();
    }

    public static ReassignWaitingList getInstance() {
        if (reassignInstance == null)
            reassignInstance = new ReassignWaitingList();
        return reassignInstance;
    }

    @Override
    public boolean addTrainee(Trainee trainee) {
        return reassignWaitingList.offer(trainee);
    }

    @Override
    public Trainee getFirstInQueue() {
        if (reassignWaitingList.size() == 0) {
            return null;
        }
        return reassignWaitingList.poll();
    }

    @Override
    public BlockingQueue<Trainee> getWaitingList() {
        return reassignWaitingList;
    }

    @Override
    public int sizeOfWaitingList() {
        return reassignWaitingList.size();
    }
}
