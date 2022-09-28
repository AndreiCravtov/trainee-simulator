package com.sparta.main.model.util;

public interface Timeable {
    public int getTime();
    public void tick();
    public boolean inGlobalGracePeriod();
    public void resetTime();
}
