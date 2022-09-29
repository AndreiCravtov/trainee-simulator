package com.sparta.main.model.waitlist.reassign;

import java.util.concurrent.LinkedBlockingQueue;

public class DataWaitingList extends ReassignWaitingList {

    private static DataWaitingList dataWaitingListInstance;

    private DataWaitingList() {
        super.dataWaitingList = new LinkedBlockingQueue<>();
    }

    public static DataWaitingList getInstance() {
        if (dataWaitingListInstance == null)
            dataWaitingListInstance = new DataWaitingList();
        return dataWaitingListInstance;
    }
}
