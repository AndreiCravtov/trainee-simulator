package com.sparta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Starter {

    public static Logger logger = LogManager.getLogger(Starter.class);

    public static void start() {

        int months=24;

        MonthIterator.monthIterate(months);

    }
}
