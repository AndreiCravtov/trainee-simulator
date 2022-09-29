package com.sparta.main.model.util;

import com.sparta.main.model.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearRandomTest {

    @Test
    @DisplayName("Functional Test")
    void test1() {
        int requirement = LinearRandom.nextInt(15, 100, 30, 2);
        if (15 < requirement && requirement < 100) {
            Assertions.assertTrue(true);
        } else {
            Assertions.assertTrue(false);
        }
    }

}