package com.sparta.main.model.waitlist;

import com.sparta.main.model.Trainee;

import java.util.concurrent.BlockingQueue;

public abstract class WaitingList {

    protected BlockingQueue<Trainee> newTraineeWaitingList;
    protected BlockingQueue<Trainee> reassignWaitingList;

    public boolean addTraineeByType(Trainee trainee, WaitingListType type) {
        if (type == null) throw new NullPointerException("Waiting List Type cannot be null");
        if (type == WaitingListType.NEWTRAINEE) return newTraineeWaitingList.offer(trainee);
        if (type == WaitingListType.REASSIGN) return reassignWaitingList.offer(trainee);
        return false;
    };

    public boolean addTraineeByID(Trainee trainee, int typeID) {
        WaitingListType type = WaitingListType.returnFromID(typeID);
        if (type == null) throw new NullPointerException("Please enter a valid ID");
        if (type == WaitingListType.NEWTRAINEE) return newTraineeWaitingList.offer(trainee);
        if (type == WaitingListType.REASSIGN) return reassignWaitingList.offer(trainee);
        return false;
    };

    /**
     * Returns the fist trainee in the new trainee waiting list.
     * @return the first trainee, if list not empty <br>
     * {@code null}, if list is empty
     */
    public Trainee getFirstInQueueByType(WaitingListType type) {
        if (type == null) throw new NullPointerException("Waiting List Type cannot be null");
        if (type == WaitingListType.NEWTRAINEE) {
            if (newTraineeWaitingList.size() == 0) {
                return null;
            }
            return newTraineeWaitingList.poll();
        }
        if (type == WaitingListType.REASSIGN) {
            if (reassignWaitingList.size() == 0) {
                return null;
            }
            return reassignWaitingList.poll();
        }
        return null;
    };

    public Trainee getFirstInQueueByID(int typeID) {
        WaitingListType type = WaitingListType.returnFromID(typeID);
        if (type == null) throw new NullPointerException("Waiting List Type cannot be null");
        if (type == WaitingListType.NEWTRAINEE) {
            if (newTraineeWaitingList.size() == 0) {
                return null;
            }
            return newTraineeWaitingList.poll();
        }
        if (type == WaitingListType.REASSIGN) {
            if (reassignWaitingList.size() == 0) {
                return null;
            }
            return reassignWaitingList.poll();
        }
        return null;
    };

    public BlockingQueue<Trainee> getWaitingListByType(WaitingListType type) {
        if (type == null) throw new NullPointerException("Waiting List Type cannot be null");
        if (type == WaitingListType.NEWTRAINEE) return newTraineeWaitingList;
        if (type == WaitingListType.REASSIGN) return reassignWaitingList;
        return null;
    };

    public BlockingQueue<Trainee> getWaitingListByID(int typeID) {
        WaitingListType type = WaitingListType.returnFromID(typeID);
        if (type == null) throw new NullPointerException("Waiting List Type cannot be null");
        if (type == WaitingListType.NEWTRAINEE) return newTraineeWaitingList;
        if (type == WaitingListType.REASSIGN) return reassignWaitingList;
        return null;
    };

    public int sizeOfWaitingListByType(WaitingListType type) {
        if (type == null) throw new NullPointerException("Waiting List Type cannot be null");
        if (type == WaitingListType.NEWTRAINEE) return newTraineeWaitingList.size();
        if (type == WaitingListType.REASSIGN) return reassignWaitingList.size();
        return 0;
    };

    public int sizeOfWaitingListByID(int typeID) {
        WaitingListType type = WaitingListType.returnFromID(typeID);
        if (type == null) throw new NullPointerException("Waiting List Type cannot be null");
        if (type == WaitingListType.NEWTRAINEE) return newTraineeWaitingList.size();
        if (type == WaitingListType.REASSIGN) return reassignWaitingList.size();
        return 0;
    };

}
