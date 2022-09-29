package com.sparta;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.client.Client;
import com.sparta.main.model.client.ClientHolder;
import com.sparta.main.model.trainingcenter.*;
import com.sparta.main.model.util.MonthTime;
import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.posttraining.ReassignWaitingList;

import java.util.Random;

public class MonthIterator {


    public static void monthIterate(int months) {

        Random rand = new Random();

        CentreHolder centreHolder = CentreHolder.getInstance();
        ClientHolder clientHolder= new ClientHolder();
        ReassignWaitingList reassignWaitingList = ReassignWaitingList.getInstance();
        NewTraineeWaitingList newTraineeWaitingList=NewTraineeWaitingList.getInstance();


        int extraTrainees;


        MonthTime monthTime = MonthTime.getInstance();

        while(monthTime.getTime() < months){
            int month=monthTime.getTime();
            if (month % 2 == 0) {
                //add a centre
                switch (rand.nextInt(0, 3)) {
                    case 0:
                        centreHolder.addToHolder(new TechCentre(monthTime));
                    case 1:
                        centreHolder.addToHolder(new TrainingHub(monthTime));
                    case 2:
                        centreHolder.addToHolder(new Bootcamp(monthTime));
                }
            }


            //adding clients
            if (month >= 12) {
                if (rand.nextInt(0, 2) == 0) {
                    // create a client
                    clientHolder.addClient(new Client(monthTime));
                }
            }


            //add trainees
            extraTrainees = rand.nextInt(51);
            for (int j = 50; j < extraTrainees + 50; j++) {
                newTraineeWaitingList.addTrainee(new Trainee());
            }


            int assignTrainees = ;



            //assign trainees + check if centre needs to be closed
            for (TrainingCentre trainingCentre : centreHolder.getCentres()) {
                assignTrainees = rand.nextInt(51);

                int counter=0;

                if ((reassignWaitingList.sizeOfReassignWaitingList()!= 0) && counter < assignTrainees) {
                    for (Trainee trainee : reassignWaitingList.getReassignWaitingList()) {
                        if (trainingCentre.canAdd(trainee)){
                            trainingCentre.addTrainee((trainee));

                            reassignWaitingList.removeReassignedTrainee(trainee);
                            counter++;
                        }
                    }
                }


                if ((newTraineeWaitingList.sizeOfWaitingList() != 0) && counter < assignTrainees) {
                    for (Trainee trainee : newTraineeWaitingList.getWaitingList()) {
                        if (trainingCentre.canAdd(trainee)){
                            trainingCentre.addTrainee((trainee));
                            newTraineeWaitingList.getFirstInQueue();
                            counter++;
                        }
                    }
                }
            }

            centreHolder.closeCentre();

            monthTime.incrementMonth();
        }
    }

}
