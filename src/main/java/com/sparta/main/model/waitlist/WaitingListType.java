package com.sparta.main.model.waitlist;

public enum WaitingListType {
    NEWTRAINEE("New Trainee Waiting List", 1),
    REASSIGN("Reassigned Trainee Waiting List", 2);

    private String name;
    private int id;

    WaitingListType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static WaitingListType returnFromID(int id) {
        if (id == 1) return NEWTRAINEE;
        if (id == 2) return REASSIGN;
        return null;
    }

    public static WaitingListType returnFromName(String name) {
        if (name.toLowerCase().contains("new trainee")) return NEWTRAINEE;
        if (name.toLowerCase().contains("reassigned")) return REASSIGN;
        return null;
    }
}
