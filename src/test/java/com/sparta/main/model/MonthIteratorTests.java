package com.sparta.main.model;

import com.sparta.MonthIterator;
import com.sparta.main.model.trainingcenter.CentreHolder;
import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.posttraining.ReassignWaitingList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MonthIteratorTests {

    public CentreHolder centreHolder;
    public ReassignWaitingList reassignWaitingList;
    public NewTraineeWaitingList newTraineeWaitingList;

    @BeforeEach
    public void setup() {
        centreHolder = CentreHolder.getInstance();
        reassignWaitingList = ReassignWaitingList.getInstance();
        newTraineeWaitingList=NewTraineeWaitingList.getInstance();
    }

    @Test
    public void monthIterate() {
        int startCentres = centreHolder.getCentres();
        MonthIterator.monthIterate(6);

    }
}
