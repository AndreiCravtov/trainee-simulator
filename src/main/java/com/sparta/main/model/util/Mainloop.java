package com.sparta.main.model.util;

public class Mainloop implements Runnable {

    private final FunctionalInterface function;
    private final int numLoops;
    private final int loopExecutionTime;

    /**
     * Creates a main loop object which executes a given function in a loop, for a given number of times.
     *
     * @param function
     * @param numLoops
     * @param loopExecutionTime
     */
    public Mainloop(FunctionalInterface function, int numLoops, int loopExecutionTime) {
        this.function = function;
        this.numLoops = numLoops;
        this.loopExecutionTime =loopExecutionTime;
    }

    @Override
    public void run() {
        for (int i=0; i<numLoops; i++) {
            long start = System.currentTimeMillis();
            long end = System.currentTimeMillis();

            Thread.sleep(s);
        }
    }
}
