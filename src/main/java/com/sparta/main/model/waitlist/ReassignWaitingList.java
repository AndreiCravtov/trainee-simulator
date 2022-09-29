package com.sparta.main.model.waitlist;

import java.util.concurrent.LinkedBlockingQueue;


public class ReassignWaitingList extends WaitingList {

    private static ReassignWaitingList reassignInstance;

    private ReassignWaitingList() {
        super.reassignWaitingList = new LinkedBlockingQueue<>();
    }

    public static ReassignWaitingList getInstance() {
        if (reassignInstance == null)
            reassignInstance = new ReassignWaitingList();
        return reassignInstance;
    }
}
