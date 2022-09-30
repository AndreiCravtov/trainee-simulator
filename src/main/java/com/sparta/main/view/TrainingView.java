package com.sparta.main.view;

import com.sparta.Starter;

import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrainingView {

    static Scanner scn = new Scanner(System.in);  // Create a Scanner object
    static Logger logger = LogManager.getLogger(Starter.class);

    public static boolean getValidBool(String message) {
        System.out.println(message);
        while (true) {
            try {
                int i = scn.nextInt();
                if (i == 0 || i == 1) {
                    if (i == 0) return false;
                    else return true;
                } else System.out.println("Enter 0 or 1");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static int getMonths(String message) throws IllegalArgumentException{
        System.out.println(message);
        while (true) {
            try {
                int userInp = scn.nextInt();
                if (userInp >2 && userInp < 5000){
                    logger.log(Level.TRACE, String.format("User decided that %s months will be simulated", userInp));
                    return userInp;
                }
                else System.out.println("Enter a number bigger than 2, less than 5000");
            } catch (Exception e) {
                logger.info(e);
                System.out.println("Please enter an integer");
                scn.nextLine();
            }
        }
    }
}

