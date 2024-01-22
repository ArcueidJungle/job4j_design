package ru.job4j.serialization.java;

public class WorkExperience {
    private final int totalExperience;
    private final int currentPlaceExperience;

    public WorkExperience(int totalExperience, int currentPlaceExperience) {
        this.totalExperience = totalExperience;
        this.currentPlaceExperience = currentPlaceExperience;
    }

    @Override
    public String toString() {
        return "workExperience{"
                + "totalExperience=" + totalExperience
                + ", currentPlaceExperience=" + currentPlaceExperience
                + '}';
    }
}
