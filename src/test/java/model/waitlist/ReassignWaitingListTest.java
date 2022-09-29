package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.ReassignWaitingList;
import com.sparta.main.model.waitlist.WaitingList;
import com.sparta.main.model.waitlist.WaitingListType;
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
        testTrainee1 = new Trainee(1, Course.JAVA);
        testTrainee2 = new Trainee(2, Course.C_SHARP);
    }

    @Test
    public void waitingList_instanceCreated() {
        testWaitingList = ReassignWaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingListByType(WaitingListType.REASSIGN));
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        testWaitingList = ReassignWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.REASSIGN);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,WaitingListType.REASSIGN));
        int afterSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.REASSIGN);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTraineeByType(testTrainee1,WaitingListType.REASSIGN);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(WaitingListType.REASSIGN));
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        testWaitingList = ReassignWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.REASSIGN);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,WaitingListType.REASSIGN));
        int afterSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.REASSIGN);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTraineeByType(testTrainee1, WaitingListType.REASSIGN);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(WaitingListType.REASSIGN));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTraineeByType(testTrainee2, WaitingListType.REASSIGN);
        testWaitingList.addTraineeByType(testTrainee1, WaitingListType.REASSIGN);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueueByType(WaitingListType.REASSIGN));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        testWaitingList = ReassignWaitingList.getInstance();
        Assertions.assertNull(testWaitingList.getFirstInQueueByType(WaitingListType.REASSIGN));
    }

    @Test
    public void waitingList_instanceCreated_byID() {
        testWaitingList = ReassignWaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingListByID(2));
    }

    @Test
    public void waitingList_addTraineeAtEnd_byID() {
        testWaitingList = ReassignWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByID(2);
        Assertions.assertTrue(testWaitingList.addTraineeByID(testTrainee1,2));
        int afterSize = testWaitingList.sizeOfWaitingListByID(2);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd_byID() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTraineeByID(testTrainee1,2);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByID(2));
    }

    @Test
    public void waitingList_addTraineeAtStart_byID() {
        testWaitingList = ReassignWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByID(2);
        Assertions.assertTrue(testWaitingList.addTraineeByID(testTrainee1,2));
        int afterSize = testWaitingList.sizeOfWaitingListByID(2);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart_byID() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTraineeByID(testTrainee1, 2);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByID(2));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees_byID() {
        testWaitingList = ReassignWaitingList.getInstance();
        testWaitingList.addTraineeByID(testTrainee2, 2);
        testWaitingList.addTraineeByID(testTrainee1, 2);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueueByID(2));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue_byID() {
        testWaitingList = ReassignWaitingList.getInstance();
        Assertions.assertNull(testWaitingList.getFirstInQueueByID(2));
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingListByType(WaitingListType.REASSIGN);
        for (int i = 0; i < size; i++) {
            testWaitingList.getFirstInQueueByType(WaitingListType.REASSIGN);
        }
    }
}
