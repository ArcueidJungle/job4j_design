package ru.job4j.io;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\kamin\\OneDrive\\Pictures", "Screenshot_3.png");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\io\\File.png"))) {
            int l = 0;
                 while ((l = in.read()) != -1) {
                     out.write(l);
                 }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
