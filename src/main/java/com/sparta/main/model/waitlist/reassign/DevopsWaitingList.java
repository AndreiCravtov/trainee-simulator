package com.sparta.main.model.waitlist.reassign;

import java.util.concurrent.LinkedBlockingQueue;

public class DevopsWaitingList extends ReassignWaitingList {

    private static DevopsWaitingList devopsWaitingListInstance;

    private DevopsWaitingList() {
        super.devopsWaitingList = new LinkedBlockingQueue<>();
    }

    public static DevopsWaitingList getInstance() {
        if (devopsWaitingListInstance == null)
            devopsWaitingListInstance = new DevopsWaitingList();
        return devopsWaitingListInstance;
    }
}
