package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.ReassignWaitingList;
import com.sparta.main.model.waitlist.WaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReassignWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;

    public WaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee(1, Course.JAVA);
        testTrainee2 = new Trainee(2, Course.C_SHARP);
    }

    @Test
    public void reassignWaitingList_noInstance() {
        Assertions.assertNull(testWaitingList);
    }

    @Test
    public void waitingList_instanceCreated() {
        testWaitingList = ReassignWaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingList());
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        testWaitingList = ReassignWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        testWaitingList = ReassignWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTrainee(testTrainee2);
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueue());
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        testWaitingList = ReassignWaitingList.getInstance();
        Assertions.assertNull(testWaitingList.getFirstInQueue());
    }

    @AfterEach
    public void setdown() {
        testWaitingList = null;
    }
}
