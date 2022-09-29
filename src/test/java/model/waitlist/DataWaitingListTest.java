package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.reassign.CWaitingList;
import com.sparta.main.model.waitlist.reassign.DataWaitingList;
import com.sparta.main.model.waitlist.reassign.ReassignWaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;
    public Trainee testTrainee3;

    public ReassignWaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee(1, Course.DATA);
        testTrainee2 = new Trainee(2, Course.DATA);
        testTrainee3 = new Trainee(3, Course.DEV_OPS);
        testWaitingList = DataWaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getWaitingListByType(Course.DATA));
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.DATA);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.DATA));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.DATA);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_addTrainee_wrongType() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.DATA);
        Assertions.assertFalse(testWaitingList.addTraineeByType(testTrainee3,Course.DATA));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.DATA);
        Assertions.assertEquals(startSize,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList.addTraineeByType(testTrainee1,Course.DATA);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.DATA));
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.DATA);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.DATA));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.DATA);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList.addTraineeByType(testTrainee1, Course.DATA);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.DATA));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList.addTraineeByType(testTrainee2, Course.DATA);
        testWaitingList.addTraineeByType(testTrainee1, Course.DATA);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueueByType(Course.DATA));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        Assertions.assertNull(testWaitingList.getFirstInQueueByType(Course.DATA));
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingListByType(Course.DATA);
        for (int i = 0; i < size; i++) {
            testWaitingList.getFirstInQueueByType(Course.DATA);
        }
    }
}
