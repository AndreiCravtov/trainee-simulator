package com.sparta;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.client.Client;
import com.sparta.main.model.client.ClientHolder;
import com.sparta.main.model.trainingcenter.*;
import com.sparta.main.model.util.MonthTime;
import com.sparta.main.model.waitlist.newtrainee.NewTraineeWaitingList;
import com.sparta.main.model.waitlist.posttraining.BenchList;
import com.sparta.main.model.waitlist.posttraining.ReassignWaitingList;

import java.util.List;
import java.util.Random;

public class MonthIterator {


    public static void monthIterate(int months) {

        Random rand = new Random();

        CentreHolder centreHolder = CentreHolder.getInstance();
        ClientHolder clientHolder= new ClientHolder();
        ReassignWaitingList reassignWaitingList = ReassignWaitingList.getInstance();
        NewTraineeWaitingList newTraineeWaitingList = NewTraineeWaitingList.getInstance();
        BenchList benchWaitingList = BenchList.getInstance();

        int extraTrainees;

        MonthTime monthTime = MonthTime.getInstance();

        while(monthTime.getTime() < months){
            System.out.println("Loop: " + monthTime.getTime());
            int month=monthTime.getTime();
            if (month % 2 == 0) {
                //add a centre
                switch (rand.nextInt(0, 3)) {
                    case 0:
                        centreHolder.addCentre(new TechCentre(monthTime));
                    case 1:
                        centreHolder.addCentre(new TrainingHub(monthTime));
                    case 2:
                        centreHolder.addCentre(new Bootcamp(monthTime));
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
            for (int j = 0; j < extraTrainees + 50; j++) {
                newTraineeWaitingList.addTrainee(new Trainee(monthTime));
            }


            int assignTrainees;

            //assign trainees + check if centre needs to be closed
            for (TrainingCentre trainingCentre : centreHolder.getCentres()) {
                assignTrainees = rand.nextInt(51);

                int counter=0;

                if ((reassignWaitingList.sizeOfReassignWaitingList()!= 0) && counter < assignTrainees) {
                    for (Trainee trainee : reassignWaitingList.getReassignWaitingList()) {
                        if (trainingCentre.canAdd(trainee)){
                            if (centreHolder.assignTrainee(trainee) != null) {
                                reassignWaitingList.removeReassignedTrainee(trainee);
                            };
                            counter++;
                        }
                    }
                }


                if ((newTraineeWaitingList.sizeOfWaitingList() != 0) && counter < assignTrainees) {
                    for (Trainee trainee : newTraineeWaitingList.getWaitingList()) {
                        if (trainingCentre.canAdd(trainee)){
                            if (centreHolder.assignTrainee(trainee) != null) {
                                newTraineeWaitingList.getFirstInQueue();
                            };
                            counter++;
                        }
                    }
                }
            }

            List<Trainee> unassignedTrainees = centreHolder.closeCentre();
            if (unassignedTrainees != null) {
                for (Trainee unassignedTrainee : unassignedTrainees) {
                    reassignWaitingList.addReassignTrainee(unassignedTrainee);
                }
            }

            // Add trainees to clients from bench
            if (monthTime.getTime() > 11 && clientHolder.getClients().size() > 0) {
                for (Trainee trainee : benchWaitingList.getBenchWaitingList()) {
                    for (Client client : clientHolder.getClients()) {
                        if (client.canAdd(trainee)) {
                            client.addTrainee(trainee);
                        }
                    }
                }
            }

            monthTime.incrementMonth();
        }
        System.out.println("Finished");
    }

}
