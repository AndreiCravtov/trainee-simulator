package com.sparta;


import com.sparta.main.model.trainingcenter.*;
import com.sparta.main.model.trainingcenter.TrainingCentre;
import com.sparta.main.model.util.MonthTime;
import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.posttraining.ReassignWaitingList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;


public class Starter {

    public static Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {

        int months=24;

        MonthIterator.monthIterate(months);

    }
}
