package com.sparta;

import com.sparta.main.view.TrainingView;

public class Starter {

    public static void start() {

        int months= TrainingView.getMonths("Enter the number of months you'd like for the simulation to run for.");

        System.out.println("Starting");
        MonthIterator monthIterator=new MonthIterator();

        monthIterator.monthIterate(months);


    }
}
