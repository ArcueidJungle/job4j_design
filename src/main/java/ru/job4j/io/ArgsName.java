package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) throws IllegalArgumentException {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '%s' is missing".formatted(key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (var arg : args) {
            var parts = arg.trim().split("=", 2);
            values.put(parts[0].substring(1), parts[1]);
        }
    }

    public static ArgsName of(String[] args) throws IllegalArgumentException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        Arrays.stream(args).forEach(ArgsName::validate);
        names.parse(args);
        return names;
    }

    public static void validate(String value) throws IllegalArgumentException {
        String toValidate = value.trim();
        if (toValidate.startsWith("-=")) {
            throw new IllegalArgumentException(
                    "Error: This argument '%s' does not contain a key".formatted(value));
        }
        if (toValidate.indexOf("=") == toValidate.length() - 1) {
            throw  new IllegalArgumentException(
                    "Error: This argument '%s' does not contain a value".formatted(value));
        }
        if (!toValidate.contains("=")) {
            throw new IllegalArgumentException(
                    "Error: This argument '%s' does not contain an equal sign".formatted(value));
        }
        if (!toValidate.startsWith("-")) {
            throw new IllegalArgumentException(
                    "Error: This argument '%s' does not start with a '-' character".formatted(value));
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("-out"));

        ArgsName name = new ArgsName();
        name.parse(new String[] {args[0], args[1]});
        System.out.println(name.get("-out"));
    }
}