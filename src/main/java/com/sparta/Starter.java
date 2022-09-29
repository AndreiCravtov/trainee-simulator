package com.sparta;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.client.Client;
import com.sparta.main.model.client.ClientHolder;
import com.sparta.main.model.trainingcenter.*;
import com.sparta.main.model.trainingcenter.TrainingCentre;
import com.sparta.main.model.util.MonthTime;

import com.sparta.main.model.waitlist.newtrainee.*;
import com.sparta.main.model.waitlist.reassign.ReassignWaitingList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Random;


public class Starter {

    public static Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {

        int months=24;

        MonthInterator.monthIterate(months);

    }
}
