package com.sparta.main.model;

public enum Courses {
    JAVA_DEVELOPER("Java Developer"),
    PYTHON_DEVELOPER("Python Developer"),
    C_SHARP_DEVELOPER("C# Developer");

    private final String name;

    public String getName() { return name; }

    private Courses(String name) { this.name = name; }
}
