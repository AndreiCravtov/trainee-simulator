package com.sparta.main.view;

import com.sparta.main.model.trainingcenter.CentreHolder;

public class ViewStatus {
    public static void viewStatus(){
        if (TrainingView.getValidBool("Would you like to print the status?")){
            System.out.printf("Centres in use: %s%n", CentreHolder.getInstance().getCentres());
        }
    }

}
