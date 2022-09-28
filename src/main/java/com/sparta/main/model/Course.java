package com.sparta.main.model;

public enum Course {
    JAVA("Java"),
    C_SHARP("C#"),
    DATA("Data"),
    DEV_OPS("DevOps"),
    BUSINESS("Business");

    private final String name;

    public String getName() { return name; }

    private Course(String name) { this.name = name; }

    @Override
    public String toString() { return name; }
}
