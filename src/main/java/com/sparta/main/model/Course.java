package com.sparta.main.model;

import java.util.Random;

public enum Course {
    JAVA("Java"),
    C_SHARP("C#"),
    DATA("Data"),
    DEV_OPS("DevOps"),
    BUSINESS("Business");

    private static final Random random = new Random();

    public static Course getRandomCourse() {
        Course[] values = values();
        return values[random.nextInt(0, values.length)];
    }

    private final String name;

    public String getName() { return name; }

    private Course(String name) { this.name = name; }

    @Override
    public String toString() { return name; }
}
