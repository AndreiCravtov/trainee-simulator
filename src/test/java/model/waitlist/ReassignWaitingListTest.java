package model.waitlist;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.reassign.ReassignWaitingList;
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
        testTrainee1 = new Trainee();
        testTrainee2 = new Trainee();
        testWaitingList = ReassignWaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        Assertions.assertNotNull(testWaitingList.getWaitingList());
    }

    @Test
    public void waitingList_addTraineeAtEnd() {
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTraineeAtEnd() {
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstTrainee());
    }

    @Test
    public void waitingList_addTrainee() {
        int startSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertTrue(testWaitingList.addTrainee(testTrainee1));
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }

    @Test
    public void waitingList_getFirstInList_OneTrainee() {
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee1, testWaitingList.getFirstTrainee());
    }

    @Test
    public void waitingList_getFirstInList_MultipleTrainees() {
        testWaitingList.addTrainee(testTrainee2);
        testWaitingList.addTrainee(testTrainee1);
        Assertions.assertEquals(testTrainee2, testWaitingList.getFirstTrainee());
    }

    @Test
    public void waitingList_getFirstInList_emptyQueue() {
        Assertions.assertNull(testWaitingList.getFirstTrainee());
    }

    @AfterEach
    public void setdown() {
        int size = testWaitingList.sizeOfWaitingList();
        for (int i = 0; i < size; i++) {
            testWaitingList.getWaitingList().remove(0);
        }
    }
}
