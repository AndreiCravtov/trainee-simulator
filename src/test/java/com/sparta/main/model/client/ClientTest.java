package com.sparta.main.model.client;

import com.sparta.main.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    List<Course> courses = new ArrayList<>();

    @BeforeEach
    void setup() {
        courses.add(Course.JAVA);
        courses.add(Course.DATA);
        courses.add(Course.DEV_OPS);
        courses.add(Course.C_SHARP);
        courses.add(Course.BUSINESS);

    }

    @Test
    @DisplayName("Functional Test")
    void test1() {
        Client client = new Client();

        boolean check = courses.contains(client.getTraineeType());
        Assertions.assertTrue(check);
    }

    @Test
    @DisplayName("Functional Test")
    void test2() {
        Client client = new Client();
        int requirement = client.getTraineesRequired();
        if (15 < requirement && requirement < 100) {
            Assertions.assertTrue(true);
        } else {
            Assertions.assertTrue(false);
        }
    }

}