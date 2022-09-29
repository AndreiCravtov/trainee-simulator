package com.sparta.main.model.client;

import com.sparta.main.model.Course;
import com.sparta.main.model.util.MonthTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
;
import java.util.Arrays;

class ClientTest {

    @Test
    @DisplayName("Functional Test")
    void test1() {
        Client client = new Client(MonthTime.getInstance());
        Course[] types = Course.values();
        boolean check = Arrays.asList(types).contains(client.getCourse());
        Assertions.assertTrue(check);
    }

}