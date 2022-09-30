package com.sparta.main.view;

import com.sparta.main.model.Trainee;
import com.sparta.main.model.client.ClientHolder;
import com.sparta.main.model.trainingcenter.CentreHolder;
import com.sparta.main.model.trainingcenter.TrainingCentre;
import com.sparta.main.model.trainingcenter.*;
import com.sparta.main.model.waitlist.*;

import java.util.ArrayList;

public class ViewStatus {
    public static void viewStatus(){
            System.out.printf("Centres in use: "+ CentreHolder.getInstance().getCentres().size() +"\n");

    }


    public static void viewFinalStatus(ArrayList<Object> list){
        CentreHolder centreHolder = (CentreHolder) list.get(0);
        ClientHolder clientHolder = (ClientHolder) list.get(1);
        ReassignWaitingList reassignWaitingList =(ReassignWaitingList) list.get(2);
        NewTraineeWaitingList newTraineeWaitingList= (NewTraineeWaitingList) list.get(3);
        BenchList benchList=(BenchList) list.get(4);

        System.out.println("For Training Hub:");
        System.out.println("There are "+ centreHolder.getNumOpenCentres(TrainingHub.class)+" open centres");
        System.out.println("There are "+ centreHolder.getNumClosedCentres(TrainingHub.class)+" closed centres");
        System.out.println("There are "+ centreHolder.getNumFullCentres(TrainingHub.class)+" full centres");
        System.out.println("There are "+ centreHolder.getNumCurrentlyTraining(TrainingHub.class)+" currently training in a training hub");

        System.out.println();

        System.out.println("For Bootcamp:");
        System.out.println("There are "+ centreHolder.getNumOpenCentres(Bootcamp.class)+" open centres");
        System.out.println("There are "+ centreHolder.getNumClosedCentres(Bootcamp.class)+" closed centres");
        System.out.println("There are "+ centreHolder.getNumFullCentres(Bootcamp.class)+" full centres");
        System.out.println("There are "+ centreHolder.getNumCurrentlyTraining(Bootcamp.class)+" currently training in a bootcamp");

        System.out.println();

        System.out.println("For Tech Centre:");
        System.out.println("There are "+ centreHolder.getNumOpenCentres(TechCentre.class)+" open centres");
        System.out.println("There are "+ centreHolder.getNumClosedCentres(TechCentre.class)+" closed centres");
        System.out.println("There are "+ centreHolder.getNumFullCentres(TechCentre.class)+" full centres");
        System.out.println("There are "+ centreHolder.getNumCurrentlyTraining(TechCentre.class)+" currently training in a tech centre");

        System.out.println();

        ArrayList<Trainee> traineesInWaiting=new ArrayList<>();
        traineesInWaiting.addAll(newTraineeWaitingList.getNewTraineeWaitingList());
        traineesInWaiting.addAll(reassignWaitingList.getReassignWaitingList());

        int java=0; int cSharp=0; int data=0; int devOps=0; int business=0;

        for (Trainee trainee: traineesInWaiting){
            switch (trainee.getCourse()){
                case DATA -> data++;
                case JAVA -> java++;
                case C_SHARP -> cSharp++;
                case BUSINESS -> business++;
                case DEV_OPS -> devOps++;
            }
        }
        System.out.println("There are "+traineesInWaiting.size() +" trainees in waiting");
        System.out.println(java + " are in a java course");
        System.out.println(data + " are in a Data Engineering course");
        System.out.println(cSharp + " are in a C# course");
        System.out.println(devOps + " are in a DevOps course");
        System.out.println(business + " are in a Business course");
        System.out.println();


        ArrayList<Trainee> traineesInTraining=new ArrayList<>();
        for (TrainingCentre centre : centreHolder.getCentres()) {
            traineesInTraining.addAll(centre.getTrainees());
        }

         java=0;  cSharp=0;  data=0;  devOps=0;  business=0;

        for (Trainee trainee: traineesInTraining){
            switch (trainee.getCourse()){
                case DATA -> data++;
                case JAVA -> java++;
                case C_SHARP -> cSharp++;
                case BUSINESS -> business++;
                case DEV_OPS -> devOps++;
            }
        }


        System.out.println("There are "+traineesInTraining.size() +" trainees in training");
        System.out.println(java + " are in a java course");
        System.out.println(data + " are in a Data Engineering course");
        System.out.println(cSharp + " are in a C# course");
        System.out.println(devOps + " are in a DevOps course");
        System.out.println(business + " are in a Business course");
        System.out.println();




    }
}
