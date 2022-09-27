package com.sparta.main.model;

public enum Course {
    JAVA_DEVELOPER("Java Developer"),
    PYTHON_DEVELOPER("Python Developer"),
    C_SHARP_DEVELOPER("C# Developer");

    private final String name;

    public String getName() { return name; }

    private Course(String name) { this.name = name; }
}
