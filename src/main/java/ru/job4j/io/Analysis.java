package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
        BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
        String line;
        boolean server = true;
        while ((line = in.readLine()) != null) {
            String[] lines = line.split(" ");
            if (server == ("400".equals(lines[0]) || "500".equals(lines[0]))) {
                server = !server;
                out.append(lines[1]).append(";").append(!server ? "" : System.lineSeparator());
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}