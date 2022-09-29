package com.sparta;

import com.sparta.main.model.trainingcenter.*;
import com.sparta.main.model.trainingcenter.TrainingCentre;
import com.sparta.main.model.util.MonthTime;
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


        MonthTime monthTime = MonthTime.getInstance();

        for (int i=0; i<months; i++) {
            if (i%2==0){
                //add a centre
                switch (rand.nextInt(0,3)){
                    case 0:
                        centreHolder.addToHolder(new TechCentre(monthTime));
                    case 1:
                        centreHolder.addToHolder(new TrainingHub(monthTime));
                    case 2:
                        centreHolder.addToHolder(new Bootcamp(monthTime)); //Bootcamp needs to be changed
                }
            }


            //adding clients
            if (i>=12){
                if (rand.nextInt(0, 2) == 0) {
                    // create a client
                }
            }


            //add trainees
            extraTrainees=rand.nextInt(50,101);


            int assignTrainees;
            //assign trainees + check if centre needs to be closed
            for (TrainingCentre trainingCentre: centreHolder.getCentres()){
                assignTrainees=rand.nextInt(51);
                //assign trainees

                //check if centre needs to be closed
                if (trainingCentre.canBeClosed()); //close training centre

            }






        }

    }
}
