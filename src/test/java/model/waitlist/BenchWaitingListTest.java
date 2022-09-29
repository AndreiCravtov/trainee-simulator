package model.waitlist;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.posttraining.BenchList;
import com.sparta.main.model.waitlist.posttraining.ReassignWaitingList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BenchWaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;

    public BenchList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee();
        testTrainee2 = new Trainee();
        testWaitingList = BenchList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getBenchWaitingList());
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        int startSize = testWaitingList.sizeOfBenchWaitingList();
        Assertions.assertTrue(testWaitingList.addBenchTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfBenchWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTraineeAtEnd() {
        testWaitingList.addBenchTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstBenchTrainee());
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfBenchWaitingList();
        Assertions.assertTrue(testWaitingList.addBenchTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfBenchWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTrainee() {
        testWaitingList.addBenchTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstBenchTrainee());
    }

    @Test
    public void waitingList_getByType_OneTrainee() {
        testWaitingList.addBenchTrainee(testTrainee1);
        Course testCourse = testTrainee1.getCourse();
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstBenchTraineeByType(testCourse));
    }

    @Test
    public void waitingList_getFirstInList_MultipleTrainees() {
        testWaitingList.addBenchTrainee(testTrainee2);
        testWaitingList.addBenchTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstBenchTrainee());
    }

    @Test
    public void waitingList_getFirstInList_emptyQueue() {
        Assertions.assertNull(testWaitingList.getFirstBenchTrainee());
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfBenchWaitingList();
        for (int i = 0; i < size; i++) {
            testWaitingList.getBenchWaitingList().remove(0);
        }
    }
}
