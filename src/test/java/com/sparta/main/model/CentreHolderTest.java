package com.sparta.main.model;

import com.sparta.main.model.trainingcenter.CentreHolder;
import com.sparta.main.model.trainingcenter.TechCentre;
import com.sparta.main.model.trainingcenter.TrainingCentre;
import com.sparta.main.model.util.MonthTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CentreHolderTest {

    @Test
    @DisplayName("Functional Test 1")
    void test1() {
        CentreHolder holder = CentreHolder.getInstance();
        TrainingCentre tc = new TechCentre(MonthTime.getInstance());
        holder.addCentre(tc);
        Assertions.assertEquals(1, holder.getCentres().size());

    }

    @Test
    @DisplayName("Functional Test 2")
    void test2() {
        CentreHolder holder = CentreHolder.getInstance();
        TrainingCentre tc = new TechCentre(MonthTime.getInstance());
        for (int i = 0; i < 50; i++) {
            holder.addCentre(tc);
        }
        Assertions.assertEquals(50, holder.getCentres().size());

    }

}