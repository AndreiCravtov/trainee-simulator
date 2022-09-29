package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.reassign.CWaitingList;
import com.sparta.main.model.waitlist.reassign.JavaWaitingList;
import com.sparta.main.model.waitlist.reassign.ReassignWaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;
    public Trainee testTrainee3;

    public ReassignWaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee(1, Course.C_SHARP);
        testTrainee2 = new Trainee(2, Course.C_SHARP);
        testTrainee3 = new Trainee(3, Course.JAVA);
        testWaitingList = CWaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getWaitingListByType(Course.C_SHARP));
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.C_SHARP);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.C_SHARP));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.C_SHARP);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_addTrainee_wrongType() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.C_SHARP);
        Assertions.assertFalse(testWaitingList.addTraineeByType(testTrainee3,Course.C_SHARP));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.C_SHARP);
        Assertions.assertEquals(startSize,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtEnd() {
        testWaitingList.addTraineeByType(testTrainee1,Course.C_SHARP);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.C_SHARP));
    }

    @Test
    public void waitingList_addTraineeAtStart() {
        int startSize = testWaitingList.sizeOfWaitingListByType(Course.C_SHARP);
        Assertions.assertTrue(testWaitingList.addTraineeByType(testTrainee1,Course.C_SHARP));
        int afterSize = testWaitingList.sizeOfWaitingListByType(Course.C_SHARP);
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInQueue_OneTraineeAtStart() {
        testWaitingList.addTraineeByType(testTrainee1, Course.C_SHARP);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstInQueueByType(Course.C_SHARP));
    }

    @Test
    public void waitingList_getFirstInQueue_MultipleTrainees() {
        testWaitingList.addTraineeByType(testTrainee2, Course.C_SHARP);
        testWaitingList.addTraineeByType(testTrainee1, Course.C_SHARP);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstInQueueByType(Course.C_SHARP));
    }

    @Test
    public void waitingList_getFirstInQueue_emptyQueue() {
        Assertions.assertNull(testWaitingList.getFirstInQueueByType(Course.C_SHARP));
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingListByType(Course.C_SHARP);
        for (int i = 0; i < size; i++) {
            testWaitingList.getFirstInQueueByType(Course.C_SHARP);
        }
    }
}
