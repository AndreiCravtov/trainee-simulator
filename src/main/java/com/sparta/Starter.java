package com.sparta;

import com.sparta.main.model.CentreHolder;
import com.sparta.main.model.trainingcenter.TrainingCentre;
import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.reassign.ReassignWaitingList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;


public class Starter {

    public static Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {

        Random rand = new Random();

        CentreHolder centreHolder = CentreHolder.getInstance();
        ReassignWaitingList reassignWaitingList = ReassignWaitingList.getInstance();
        NewTraineeWaitingList newTraineeWaitingList=NewTraineeWaitingList.getInstance();

        //Need to write view for this
        int months=0; //months for which the simulation would be running

        int extraTrainees;

        for (int i=0; i<months; i++) {
            if (i%2==0){
                //add a centre
            }

            //add trainees
            extraTrainees=rand.nextInt(50,101);


            //do checks
            for (TrainingCentre trainingCentre: centreHolder.getCentres()){
                //check if needs to be closed
            }

        }

    }
}
