package com.sparta.main.model;

import com.sparta.MonthIterator;
import com.sparta.main.model.client.ClientHolder;
import com.sparta.main.model.trainingcenter.CentreHolder;
import com.sparta.main.model.util.MonthTime;
import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.posttraining.ReassignWaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
    public void monthIterate_6() {
        int startCentres = centreHolder.getCentres().size();
        int startReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int startNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        MonthIterator.monthIterate(6);
        int endCentres = centreHolder.getCentres().size();
        int endReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int endNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(endCentres > startCentres);
        Assertions.assertTrue(endReassignSize == startReassignSize);
        Assertions.assertTrue(endNewTraineeSize > startNewTraineeSize);
    }

    @Test
    public void monthIterate_12() {
        int startCentres = centreHolder.getCentres().size();
        int startReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int startNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        MonthIterator.monthIterate(12);
        int endCentres = centreHolder.getCentres().size();
        int endReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int endNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(endCentres > startCentres);
        Assertions.assertTrue(endReassignSize == startReassignSize);
        Assertions.assertTrue(endNewTraineeSize > startNewTraineeSize);
    }

    @Test
    public void monthIterate_24() {
        int startCentres = centreHolder.getCentres().size();
        int startReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int startNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        MonthIterator.monthIterate(24);
        int endCentres = centreHolder.getCentres().size();
        int endReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int endNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(endCentres > startCentres);
        Assertions.assertTrue(endReassignSize == startReassignSize);
        Assertions.assertTrue(endNewTraineeSize > startNewTraineeSize);
    }

    @Test
    public void monthIterate_100() {
        int startCentres = centreHolder.getCentres().size();
        int startReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int startNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        MonthIterator.monthIterate(100);
        int endCentres = centreHolder.getCentres().size();
        int endReassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        int endNewTraineeSize = newTraineeWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(endCentres > startCentres);
        Assertions.assertTrue(endReassignSize == startReassignSize);
        Assertions.assertTrue(endNewTraineeSize > startNewTraineeSize);
    }

    @AfterEach
    public void setdown() {
        int reassignSize = reassignWaitingList.sizeOfReassignWaitingList();
        for (int i = 0; i < reassignSize; i++) {
            reassignWaitingList.getReassignWaitingList().remove(0);
        }
        int traineeSize = newTraineeWaitingList.sizeOfWaitingList();
        for (int i = 0; i < traineeSize; i++) {
            newTraineeWaitingList.getFirstInQueue();
        }
        int centreSize = centreHolder.getCentres().size();
        for (int i = 0; i < centreSize; i++) {
            centreHolder.getCentres().remove(0);
        }
        MonthTime.getInstance().resetTime();
    }
}
