package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.WaitingListType;
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
        testTrainee1 = new Trainee(1, Course.JAVA);
        testTrainee2 = new Trainee(2, Course.C_SHARP);
    }

    @Test
    public void waitingList_instanceCreated() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingListByType(WaitingListType.NEWTRAINEE));
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.NEWTRAINEE);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,WaitingListType.NEWTRAINEE));
        int afterSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.NEWTRAINEE);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTraineeByType(testTrainee1, WaitingListType.NEWTRAINEE);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(WaitingListType.NEWTRAINEE));
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.NEWTRAINEE);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1, WaitingListType.NEWTRAINEE));
        int afterSize = testWaitingList.sizeOfWaitingListByType(WaitingListType.NEWTRAINEE);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTraineeByType(testTrainee1, WaitingListType.NEWTRAINEE);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(WaitingListType.NEWTRAINEE));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTraineeByType(testTrainee2, WaitingListType.NEWTRAINEE);
        testWaitingList.addTraineeByType(testTrainee1, WaitingListType.NEWTRAINEE);
        Assertions.assertEquals(testTrainee2, testWaitingList.getWaitingListByType(WaitingListType.NEWTRAINEE));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        Assertions.assertNull(testWaitingList.getWaitingListByType(WaitingListType.NEWTRAINEE));
    }

    @Test
    public void waitingList_instanceCreated_byID() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingListByID(1));
    }

    @Test
    public void waitingList_addTraineeAtEnd_byID() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByID(1);
        Assertions.assertTrue(testWaitingList.addTraineeByID(testTrainee1,1));
        int afterSize = testWaitingList.sizeOfWaitingListByID(1);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd_byID() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTraineeByID(testTrainee1, 1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByID(1));
    }

    @Test
    public void waitingList_addTraineeAtStart_byID() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        int startSize = testWaitingList.sizeOfWaitingListByID(1);
        Assertions.assertTrue(testWaitingList.addTraineeByID(testTrainee1, 1));
        int afterSize = testWaitingList.sizeOfWaitingListByID(1);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart_byID() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTraineeByID(testTrainee1, 1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByID(1));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees_byID() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        testWaitingList.addTraineeByID(testTrainee2, 1);
        testWaitingList.addTraineeByID(testTrainee1, 1);
        Assertions.assertEquals(testTrainee2, testWaitingList.getWaitingListByID(1));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue_byID() {
        testWaitingList = NewTraineeWaitingList.getInstance();
        Assertions.assertNull(testWaitingList.getWaitingListByID(1));
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingListByType(WaitingListType.NEWTRAINEE);
        for (int i = 0; i < size; i++) {
            testWaitingList.getWaitingListByType(WaitingListType.NEWTRAINEE);
        }
    }
}
