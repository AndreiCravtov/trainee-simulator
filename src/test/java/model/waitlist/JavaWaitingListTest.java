package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.reassign.BusinessWaitingList;
import com.sparta.main.model.waitlist.reassign.JavaWaitingList;
import com.sparta.main.model.waitlist.reassign.ReassignWaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;
    public Trainee testTrainee3;

    public ReassignWaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee(1, Course.JAVA);
        testTrainee2 = new Trainee(2, Course.JAVA);
        testTrainee3 = new Trainee(2, Course.DEV_OPS);
        testWaitingList = JavaWaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getWaitingListByType(Course.JAVA));
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.JAVA);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.JAVA));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.JAVA);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_addTrainee_wrongType() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.JAVA);
        Assertions.assertFalse(testWaitingList.addTraineeByType(testTrainee3,Course.JAVA));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.JAVA);
        Assertions.assertEquals(startSize,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList.addTraineeByType(testTrainee1,Course.JAVA);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.JAVA));
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.JAVA);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.JAVA));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.JAVA);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList.addTraineeByType(testTrainee1, Course.JAVA);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.JAVA));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList.addTraineeByType(testTrainee2, Course.JAVA);
        testWaitingList.addTraineeByType(testTrainee1, Course.JAVA);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueueByType(Course.JAVA));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        Assertions.assertNull(testWaitingList.getFirstInQueueByType(Course.JAVA));
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingListByType(Course.JAVA);
        for (int i = 0; i < size; i++) {
            testWaitingList.getFirstInQueueByType(Course.JAVA);
        }
    }
}
