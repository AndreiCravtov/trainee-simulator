package model;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.WaitingList;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;

    public WaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee(1, Course.JAVA);
        testTrainee2 = new Trainee(2, Course.C_SHARP);
    }

    @Test
    public void waitingList_noInstance() {
        Assertions.assertNull(testWaitingList);
    }

    @Test
    public void waitingList_instanceCreated() {
        testWaitingList = WaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingList());
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        testWaitingList = WaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTraineeAtEnd(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList = WaitingList.getInstance();
        testWaitingList.addTraineeAtEnd(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        testWaitingList = WaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTraineeAtStart(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList = WaitingList.getInstance();
        testWaitingList.addTraineeAtStart(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList = WaitingList.getInstance();
        testWaitingList.addTraineeAtEnd(testTrainee1);
        testWaitingList.addTraineeAtStart(testTrainee2);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        testWaitingList = WaitingList.getInstance();
        Assertions.assertNull(testWaitingList.getFirstInQueue());
    }

    @AfterEach
    public void setdown() {
        testWaitingList = null;
    }
}
