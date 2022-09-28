package com.sparta.main.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CentreHolderTest {

    @Test
    @DisplayName("Functional Test 1")
    void test1() {
        CentreHolder holder = CentreHolder.getInstance();
        TrainingCentre tc = new TrainingCentre(6969);
        holder.addToHolder(tc);
        Assertions.assertEquals(1, CentreHolder.getCentres().size());

    }

}