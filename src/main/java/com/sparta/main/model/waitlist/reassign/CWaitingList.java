package com.sparta.main.model.waitlist.reassign;

import java.util.concurrent.LinkedBlockingQueue;

public class CWaitingList extends ReassignWaitingList {

    private static CWaitingList cWaitingListInstance;

    private CWaitingList() {
        super.cWaitingList = new LinkedBlockingQueue<>();
    }

    public static CWaitingList getInstance() {
        if (cWaitingListInstance == null)
            cWaitingListInstance = new CWaitingList();
        return cWaitingListInstance;
    }
}
