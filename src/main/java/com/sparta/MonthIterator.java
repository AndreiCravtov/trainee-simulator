package com.sparta;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.client.Client;
import com.sparta.main.model.client.ClientHolder;
import com.sparta.main.model.trainingcenter.*;
import com.sparta.main.model.util.MonthTime;
import com.sparta.main.model.waitlist.*;

import java.time.Month;
import java.util.List;
import java.util.Random;

public class MonthIterator {
    Random rand = new Random();

    CentreHolder centreHolder = CentreHolder.getInstance();
    ClientHolder clientHolder= new ClientHolder();
    ReassignWaitingList reassignWaitingList = ReassignWaitingList.getInstance();
    NewTraineeWaitingList newTraineeWaitingList = NewTraineeWaitingList.getInstance();
    BenchList benchWaitingList = BenchList.getInstance();
    MonthTime monthTime = MonthTime.getInstance();

    private void addCentre(){
        if (monthTime.currentMonth() % 2 == 0) {
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
    }

    private void addClients(){
        if (monthTime.currentMonth() >= 12) {
            if (rand.nextInt(0, 2) == 0) {
                // create a client
                clientHolder.addClient(new Client(monthTime));
            }
        }
    }

    private void addTrainees(){
        int extraTrainees = rand.nextInt(51);
        for (int j = 0; j < extraTrainees + 50; j++) {
            newTraineeWaitingList.addNewTrainee(new Trainee( monthTime));
        }
    }

    private void assignTrainees(){
        for (TrainingCentre trainingCentre : centreHolder.getCentres()) {
            int assignTrainees = rand.nextInt(51);

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


            if ((newTraineeWaitingList.sizeOfNewTraineeWaitingList() != 0) && counter < assignTrainees) {
                for (Trainee trainee : newTraineeWaitingList.getNewTraineeWaitingList()) {
                    if (trainingCentre.canAdd(trainee)){
                        if (centreHolder.assignTrainee(trainee) != null) {
                            newTraineeWaitingList.removeNewTrainee(trainee);
                        };
                        counter++;
                    }
                }
            }
        }
    }


    private void assignFromBench(){
        if (monthTime.getTime() >= 12 && clientHolder.getClients().size() > 0) {
            for (Trainee trainee : benchWaitingList.getBenchWaitingList()) {
                for (Client client : clientHolder.getClients()) {
                    if (client.canAdd(trainee)) {
                        client.addTrainee(trainee);
                    }
                }
            }
        }
    }
    public  void monthIterate(int months) {




        int extraTrainees;


        while(monthTime.getTime() < months){
            System.out.println("Loop: " + monthTime.getTime());
            int month=monthTime.getTime();

            addCentre();
            addClients();
            addTrainees();
            assignTrainees();

            List<Trainee> reassignTrainees=centreHolder.closeCentres();
            for (Trainee trainee:reassignTrainees){
                reassignWaitingList.addReassignTrainee(trainee);
            }
            assignFromBench();



            monthTime.incrementMonth();
        }
        System.out.println("Finished");
    }

}
