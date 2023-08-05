package ru.job4j.map;

import java.util.Calendar;

public class User {
    final String name;
    final int children;
    final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
