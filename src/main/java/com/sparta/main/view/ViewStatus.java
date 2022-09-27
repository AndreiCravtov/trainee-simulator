package com.sparta.main.view;

import com.sparta.main.model.CentreHolder;

public class ViewStatus {
    public static void viewStatus(){

        if (TrainingView.getValidBool("Would you like to print the status?")){
            System.out.println("Centres in use:  "+ CentreHolder.getCentres());
        }
    }

}
