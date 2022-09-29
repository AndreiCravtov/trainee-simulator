package com.sparta.main.model.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

class ClientTest {

    @Test
    @DisplayName("Functional Test")
    void test1() {
        Client client = new Client();
        String[] types = new String[] {"JAVA", "C#", "DEV-OPS", "TESTING", "BUSINESS"};
        boolean check = Arrays.asList(types).contains(client.getCourse());
        Assertions.assertTrue(check);
    }

}