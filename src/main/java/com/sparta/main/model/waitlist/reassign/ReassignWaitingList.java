package com.sparta.main.model.waitlist.reassign;

import com.sparta.main.model.Course;
import com.sparta.main.model.Trainee;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public abstract class ReassignWaitingList  {

    protected BlockingQueue<Trainee> javaWaitingList;
    protected BlockingQueue<Trainee> cWaitingList;
    protected BlockingQueue<Trainee> dataWaitingList;
    protected BlockingQueue<Trainee> devopsWaitingList;
    protected BlockingQueue<Trainee> businessWaitingList;

    public boolean addTraineeByType(Trainee trainee, Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        if (type != trainee.getCourse()) return false;
        if (type == Course.JAVA) return javaWaitingList.offer(trainee);
        if (type == Course.C_SHARP) return cWaitingList.offer(trainee);
        if (type == Course.DATA) return dataWaitingList.offer(trainee);
        if (type == Course.DEV_OPS) return devopsWaitingList.offer(trainee);
        if (type == Course.BUSINESS) return businessWaitingList.offer(trainee);
        return false;
    };

    /**
     * Returns the fist trainee in the new trainee waiting list.
     * @return the first trainee, if list not empty <br>
     * {@code null}, if list is empty
     */
    public Trainee getFirstInQueueByType(Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        if (type == Course.JAVA) {
            if (javaWaitingList.size() == 0) {
                return null;
            }
            return javaWaitingList.poll();
        }
        if (type == Course.C_SHARP) {
            if (cWaitingList.size() == 0) {
                return null;
            }
            return cWaitingList.poll();
        }
        if (type == Course.DATA) {
            if (dataWaitingList.size() == 0) {
                return null;
            }
            return dataWaitingList.poll();
        }
        if (type == Course.DEV_OPS) {
            if (devopsWaitingList.size() == 0) {
                return null;
            }
            return devopsWaitingList.poll();
        }
        if (type == Course.BUSINESS) {
            if (businessWaitingList.size() == 0) {
                return null;
            }
            return businessWaitingList.poll();
        }
        return null;
    };

    public BlockingQueue<Trainee> getWaitingListByType(Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        if (type == Course.JAVA) return javaWaitingList;
        if (type == Course.C_SHARP) return cWaitingList;
        if (type == Course.DATA) return dataWaitingList;
        if (type == Course.DEV_OPS) return devopsWaitingList;
        if (type == Course.BUSINESS) return businessWaitingList;
        return null;
    };

    public int sizeOfWaitingListByType(Course type) {
        if (type == null) throw new NullPointerException("Course Type cannot be null");
        if (type == Course.JAVA) return javaWaitingList.size();
        if (type == Course.C_SHARP) return cWaitingList.size();
        if (type == Course.DATA) return dataWaitingList.size();
        if (type == Course.DEV_OPS) return devopsWaitingList.size();
        if (type == Course.BUSINESS) return businessWaitingList.size();
        return 0;
    };
}
