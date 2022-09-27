package model;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.WaitingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WaitingListTest {

    public Trainee testTrainee1;
    public Trainee testTrainee2;

    public WaitingList testWaitingList;

    @BeforeEach
    public void setup() {
        testTrainee1 = new Trainee();
        testTrainee2 = new Trainee();
        testWaitingList = WaitingList.getInstance();
    }

    @Test
    public void waitingList_instanceCreated() {
        WaitingList.getInstance();
        Assertions.assertNotNull(testWaitingList.getWaitingList());
    }

    @Test
    public void waitingList_addTrainees() {
        int startSize = testWaitingList.sizeOfWaitingList();
        testWaitingList.addTrainee(testTrainee1);
        int afterSize = testWaitingList.sizeOfWaitingList();
        Assertions.assertEquals(startSize+1,afterSize);
    }
}
