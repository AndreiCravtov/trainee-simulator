package com.sparta.main.view;

public class ViewStatus {
    public static void viewStatus(){
        System.out.println("Would you like to print the status?");

        if (TrainingView.getValidBool("Would you like to print the status?")){
            System.out.println();
        }
    }

}
