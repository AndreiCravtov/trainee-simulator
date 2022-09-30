package com.sparta.main.model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.util.MonthTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewTraineeWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;

    public NewTraineeWaitingList testWaitingList;

    public MonthTime monthTime;

    @BeforeEach
    public void setup() {
        monthTime = MonthTime.getInstance();
        testTrainee1 = new Trainee(monthTime);
        testTrainee2 = new Trainee(monthTime);
        testWaitingList = NewTraineeWaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getNewTraineeWaitingList());
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        int startSize = testWaitingList.sizeOfNewTraineeWaitingList();
        Assertions.assertTrue(testWaitingList.addNewTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfNewTraineeWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTraineeAtEnd() {
        testWaitingList.addNewTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstNewTrainee());
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfNewTraineeWaitingList();
        Assertions.assertTrue(testWaitingList.addNewTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfNewTraineeWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTrainee() {
        testWaitingList.addNewTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstNewTrainee());
    }

    @Test
    public void waitingList_getByType_OneTrainee() {
        testWaitingList.addNewTrainee(testTrainee1);
        Course testCourse = testTrainee1.getCourse();
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstNewTraineeByType(testCourse));
    }

    @Test
    public void waitingList_getFirstInList_MultipleTrainees() {
        testWaitingList.addNewTrainee(testTrainee2);
        testWaitingList.addNewTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee2, testWaitingList.getNewTraineeWaitingList());
    }

    @Test
    public void waitingList_getFirstInList_emptyQueue() {
        Assertions.assertNull(testWaitingList.getNewTraineeWaitingList());
    }

    @Test
    public void waitingList_numberOfTrainees_ByType() {
        testWaitingList.addNewTrainee(testTrainee2);
        testWaitingList.addNewTrainee(testTrainee1);
        Course trainee1course = testTrainee1.getCourse();
        if (trainee1course == testTrainee2.getCourse()) {
            Assertions.assertEquals(2, testWaitingList.numberOfNewTraineeOfType(trainee1course));
        }
        else {
            Assertions.assertEquals(1, testWaitingList.numberOfNewTraineeOfType(trainee1course));
        }
    }

    @Test
    public void waitingList_removeTrainees() {
        testWaitingList.addNewTrainee(testTrainee1);
        Assertions.assertEquals(1,testWaitingList.sizeOfNewTraineeWaitingList());
        Trainee removedTrainee = testWaitingList.removeNewTrainee(testTrainee1);
        Assertions.assertNotNull(removedTrainee);
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfNewTraineeWaitingList();
        for (int i = 0; i < size; i++) {
            testWaitingList.getNewTraineeWaitingList().remove(0);
        }
    }
}
