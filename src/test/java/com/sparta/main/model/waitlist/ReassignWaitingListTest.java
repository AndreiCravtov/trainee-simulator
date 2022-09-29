package com.sparta.main.model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReassignWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;

    public ReassignWaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee();
        testTrainee2 = new Trainee();
        testWaitingList = ReassignWaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getReassignWaitingList());
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        int startSize = testWaitingList.sizeOfReassignWaitingList();
        Assertions.assertTrue(testWaitingList.addReassignTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfReassignWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTraineeAtEnd() {
        testWaitingList.addReassignTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstReassignTrainee());
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfReassignWaitingList();
        Assertions.assertTrue(testWaitingList.addReassignTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfReassignWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTrainee() {
        testWaitingList.addReassignTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstReassignTrainee());
    }

    @Test
    public void waitingList_getByType_OneTrainee() {
        testWaitingList.addReassignTrainee(testTrainee1);
        Course testCourse = testTrainee1.getCourse();
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstReassignTraineeByType(testCourse));
    }

    @Test
    public void waitingList_getFirstInList_MultipleTrainees() {
        testWaitingList.addReassignTrainee(testTrainee2);
        testWaitingList.addReassignTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstReassignTrainee());
    }

    @Test
    public void waitingList_getFirstInList_emptyQueue() {
        Assertions.assertNull(testWaitingList.getFirstReassignTrainee());
    }

    @Test
    public void waitingList_numberOfTrainees_ByType() {
        testWaitingList.addReassignTrainee(testTrainee2);
        testWaitingList.addReassignTrainee(testTrainee1);
        Course trainee1course = testTrainee1.getCourse();
        if (trainee1course == testTrainee2.getCourse()) {
            Assertions.assertEquals(2, testWaitingList.numberOfReassignedTraineeOfType(trainee1course));
        }
        else {
            Assertions.assertEquals(1, testWaitingList.numberOfReassignedTraineeOfType(trainee1course));
        }
    }

    @Test
    public void waitingList_removeTrainees() {
        testWaitingList.addReassignTrainee(testTrainee1);
        Assertions.assertEquals(1,testWaitingList.sizeOfReassignWaitingList());
        boolean removedTrainee = testWaitingList.removeReassignedTrainee(testTrainee1);
        Assertions.assertNotNull(removedTrainee);
        Assertions.assertTrue(removedTrainee);
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfReassignWaitingList();
        for (int i = 0; i < size; i++) {
            testWaitingList.getReassignWaitingList().remove(0);
        }
    }
}
