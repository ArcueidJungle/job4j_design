package ru.job4j.serialization.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Employee employee = new Employee(false, 25,
                new WorkExperience(6, 2),
                new String[]{"Ivan", "Lavrentev"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(employee));
        final String employeeJson =
                "{" +
                        "\"isMarried\":true,"
                + "\"age\":26,"
                + "\"workExperience\":"
                + "{"
                + "\"totalExperience\" :6,"
                + "\"currentPlaceExperience\" :2"
                + "},"
                + "\"fullname\":"
                + "[\"Ivan\",\"Lavrentev\"]"
                + "}";
        final Employee employee1 = gson.fromJson(employeeJson, Employee.class);
        System.out.println(employee1);
    }
}