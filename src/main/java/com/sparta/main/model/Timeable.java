package com.sparta.main.model;

public interface Timeable {
    public int getTime();
    public void tick();
    public boolean isGlobalGracePeriod();
    public void resetTime();
}
