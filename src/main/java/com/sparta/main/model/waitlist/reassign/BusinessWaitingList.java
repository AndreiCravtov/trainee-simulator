package com.sparta.main.model.waitlist.reassign;

import java.util.concurrent.LinkedBlockingQueue;

public class BusinessWaitingList extends ReassignWaitingList {

    private static BusinessWaitingList businessWaitingListInstance;

    private BusinessWaitingList() {
        super.businessWaitingList = new LinkedBlockingQueue<>();
    }

    public static BusinessWaitingList getInstance() {
        if (businessWaitingListInstance == null)
            businessWaitingListInstance = new BusinessWaitingList();
        return businessWaitingListInstance;
    }
}
