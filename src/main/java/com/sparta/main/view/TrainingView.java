package com.sparta.main.view;

import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrainingView {

    public static boolean getValidBool(String message) {
        Scanner scn = new Scanner(System.in);  // Create a Scanner object
        Logger logger = null;

        System.out.println(message);
        while (true) {
            try {
                int i = scn.nextInt();
                if (i == 0 || i == 1) {
                    if (i == 0) return false;
                    else return false;
                } else System.out.println("Enter 0 or 1");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}

