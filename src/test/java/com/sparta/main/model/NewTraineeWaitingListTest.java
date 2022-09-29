package com.sparta.main.model;

import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewTraineeWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;

    public NewTraineeWaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee();
        testTrainee2 = new Trainee();
    }

    @Test
    public void waitingList_instanceCreated() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingList());
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTrainee(testTrainee2);
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        Assertions.assertNull(testWaitingList.getFirstInQueue());
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingList();
        for (int i = 0; i < size; i++) {
            testWaitingList.getFirstInQueue();
        }
    }
}
