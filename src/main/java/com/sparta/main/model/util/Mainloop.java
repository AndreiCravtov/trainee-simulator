package com.sparta.main.model.util;

public class Mainloop implements Runnable {

    public interface Function {
        void run();
    }

    private final Function function;
    private final int numLoops;
    private final int loopExecutionTime;

    /**
     * Creates a main loop object which executes a given function in a loop, for a given number of times.
     *
     * @param function the function to run
     * @param numLoops the number of times to run the function
     */
    public Mainloop(Function function, int numLoops) {
        loopExecutionTime = 0;
        this.function = function;
        this.numLoops = numLoops;
    }

    /**
     * Creates a main loop object which executes a given function in a loop, for a given number of times.
     *
     * @param function the function to run
     * @param numLoops the number of times to run the function
     * @param loopExecutionTime the time each loop should execute for (in ms)
     */
    public Mainloop(Function function, int numLoops, int loopExecutionTime) {
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
