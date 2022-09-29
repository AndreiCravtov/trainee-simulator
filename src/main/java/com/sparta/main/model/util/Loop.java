package com.sparta.main.model.util;

/**
 * A class to abstract away running a loop. Whatever functionality is passed to it, will be run in a loop.
 */
public class Loop implements Runnable {

    /**
     * The empty anonymous function that the {@code Loop} runs
     */
    public interface Function {
        /**
         * The method to run the provided function
         */
        void run();
    }

    private final Function function;
    private int numLoops;
    private int loopExecutionTime;

    public int getNumLoops() { return numLoops; }

    public int getLoopExecutionTime() { return loopExecutionTime; }

    public void setNumLoops(int numLoops) { this.numLoops = numLoops; }

    public void setLoopExecutionTime(int loopExecutionTime) { this.loopExecutionTime = loopExecutionTime; }

    /**
     * Creates a main loop object which executes a given function in a loop.
     *
     * @param function the function to run
     */
    public Loop(Function function) {
        this.function = function;
        numLoops = 0;
        loopExecutionTime = 0;
    }

    /**
     * Creates a main loop object which executes a given function in a loop, for a given number of times.
     *
     * @param function the function to run
     * @param numLoops the number of times to run the function
     */
    public Loop(Function function, int numLoops) {
        this.function = function;
        this.numLoops = numLoops;
        loopExecutionTime = 0;
    }

    /**
     * Creates a main loop object which executes a given function in a loop, for a given number of times.
     *
     * @param function the function to run
     * @param numLoops the number of times to run the function
     * @param loopExecutionTime the time each loop should execute for (in ms)
     */
    public Loop(Function function, int numLoops, int loopExecutionTime) {
        this.function = function;
        this.numLoops = numLoops;
        this.loopExecutionTime = loopExecutionTime;
    }

    /**
     * Runs the main loop as defined in the constructor.
     */
    @Override
    public void run() {
        for (int i=0; i<numLoops; i++) {
            long start = System.currentTimeMillis();
            function.run();
            long end = System.currentTimeMillis();
            try { Thread.sleep(loopExecutionTime - (end - start)); }
            catch (Exception ignored) {}
        }
    }
}
