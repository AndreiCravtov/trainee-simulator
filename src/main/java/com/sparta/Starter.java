package com.sparta;

import com.sparta.main.view.DisplayManager;
import com.sparta.main.view.TrainingView;

public class Starter {

    public static void start() {

        int months= TrainingView.getMonths("Enter the number of months you'd like for the simulation to run for.");
        boolean bool = TrainingView.getValidBool("Press 1 to print status at the end of each month, 0 otherwise");


        System.out.println("Starting");
        MonthIterator monthIterator=new MonthIterator();

        monthIterator.monthIterate(months,bool);



    }
}
