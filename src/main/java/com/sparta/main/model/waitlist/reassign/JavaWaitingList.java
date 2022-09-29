package com.sparta.main.model.waitlist.reassign;

import java.util.concurrent.LinkedBlockingQueue;

public class JavaWaitingList extends ReassignWaitingList {

    private static JavaWaitingList javaWaitingListInstance;

    private JavaWaitingList() {
        super.javaWaitingList = new LinkedBlockingQueue<>();
    }

    public static JavaWaitingList getInstance() {
        if (javaWaitingListInstance == null)
            javaWaitingListInstance = new JavaWaitingList();
        return javaWaitingListInstance;
    }
}
