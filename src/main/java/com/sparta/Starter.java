package com.sparta;

import com.sparta.main.view.DisplayManager;
import com.sparta.main.view.TrainingView;
import com.sparta.main.view.ViewStatus;

import java.util.ArrayList;

public class Starter {

    public static void start() {

        int months= TrainingView.getMonths("Enter the number of months you'd like for the simulation to run for.");
        boolean bool = TrainingView.getValidBool("Press 1 to print status at the end of each month, 0 otherwise");


        System.out.println("Starting");
        MonthIterator monthIterator=new MonthIterator();

        ArrayList<Object> list= monthIterator.monthIterate(months,bool);

        bool= TrainingView.getValidBool("Press 1 if you would like to get status, 0 otherwise");
        if (bool){
            ViewStatus.viewFinalStatus(list);
        }
    }
}
