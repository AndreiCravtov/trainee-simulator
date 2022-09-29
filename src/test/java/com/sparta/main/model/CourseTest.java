package com.sparta.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    @DisplayName("Name compare test")
    void test1() {
        Course course = Course.JAVA;
        Assertions.assertEquals("Java", course.getName());
    }

    @Test
    @DisplayName("Name compare test 2")
    void test2() {
        Course course = Course.C_SHARP;
        Assertions.assertEquals("C#", course.getName());
    }

}