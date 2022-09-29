package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.reassign.BusinessWaitingList;
import com.sparta.main.model.waitlist.reassign.ReassignWaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BusinessWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;
    public Trainee testTrainee3;

    public ReassignWaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee(1, Course.BUSINESS);
        testTrainee2 = new Trainee(2, Course.BUSINESS);
        testTrainee3 = new Trainee(3, Course.DATA);
        testWaitingList = BusinessWaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getWaitingListByType(Course.BUSINESS));
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.BUSINESS);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.BUSINESS));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.BUSINESS);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_addTrainee_wrongType() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.BUSINESS);
        Assertions.assertFalse(testWaitingList.addTraineeByType(testTrainee3,Course.BUSINESS));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.BUSINESS);
        Assertions.assertEquals(startSize,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList.addTraineeByType(testTrainee1,Course.BUSINESS);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.BUSINESS));
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.BUSINESS);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.BUSINESS));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.BUSINESS);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList.addTraineeByType(testTrainee1, Course.BUSINESS);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.BUSINESS));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList.addTraineeByType(testTrainee2, Course.BUSINESS);
        testWaitingList.addTraineeByType(testTrainee1, Course.BUSINESS);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueueByType(Course.BUSINESS));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        Assertions.assertNull(testWaitingList.getFirstInQueueByType(Course.BUSINESS));
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingListByType(Course.BUSINESS);
        for (int i = 0; i < size; i++) {
            testWaitingList.getFirstInQueueByType(Course.BUSINESS);
        }
    }
}
