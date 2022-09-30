package com.sparta.main.view;

import com.sparta.main.model.client.ClientHolder;
import com.sparta.main.model.trainingcenter.CentreHolder;
import com.sparta.main.model.waitlist.*;

import java.util.ArrayList;

public class ViewStatus {
    public static void viewStatus(){
        if (TrainingView.getValidBool("Would you like to print the status?")){
            System.out.printf("Centres in use: %s%n", CentreHolder.getInstance().getCentres());
        }
    }

//    public static int viewWaitingLists(ArrayList<Object> list){
//        ReassignWaiting= list.get(0)
//    }
    public static void viewFinalStatus(ArrayList<Object> list){
        CentreHolder centreHolder = (CentreHolder) list.get(0);
        ClientHolder clientHolder = (ClientHolder) list.get(1);
        ReassignWaitingList reassignWaitingList =(ReassignWaitingList) list.get(2);
        NewTraineeWaitingList newTraineeWaitingList= (NewTraineeWaitingList) list.get(3);
        BenchList benchList=(BenchList) list.get(4);

        System.out.println();


    }




}
