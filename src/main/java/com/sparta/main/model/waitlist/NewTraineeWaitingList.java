package com.sparta.main.model.waitlist;

import java.util.concurrent.LinkedBlockingQueue;

public class NewTraineeWaitingList extends WaitingList {

    private static NewTraineeWaitingList newTraineeInstance;

    private NewTraineeWaitingList() {
        super.newTraineeWaitingList = new LinkedBlockingQueue<>();
    }

    public static NewTraineeWaitingList getInstance() {
        if (newTraineeInstance == null)
            newTraineeInstance = new NewTraineeWaitingList();
        return newTraineeInstance;
    }

}
