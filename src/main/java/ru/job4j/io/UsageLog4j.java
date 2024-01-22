package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        boolean isValid = true;
        short count = 128;
        byte bite = 127;
        int i = 234667;
        long l = 321000000;
        double d = 1.1E+7;
        float f = 1.6F;
        char ch = 'm';
        LOG.debug("isValid: {} , count: {}, bite: {}, i: {}, l: {}, d: {}, f: {}, ch: {}",
                isValid, count, bite, i, l, d, f, ch);
    }
}