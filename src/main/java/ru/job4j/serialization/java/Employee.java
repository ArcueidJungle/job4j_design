package ru.job4j.serialization.java;

import java.util.Arrays;

public class Employee {
    private final boolean isMarried;
    private final int age;
    private final WorkExperience workExperience;
    private final String[] fullname;

    public Employee(boolean isMarried, int age, WorkExperience workExperience, String[] fullname) {
        this.isMarried = isMarried;
        this.age = age;
        this.workExperience = workExperience;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "isMarried=" + isMarried
                + ", age=" + age
                + ", workExperience=" + workExperience
                + ", Fullname=" + Arrays.toString(fullname)
                + '}';
    }
}
