package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length) {
            if (data[row].length != 0) {
                return true;
            }
            arrIt();
        } return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = data[row][column];
        arrIt();
        return rsl;
    }

    public void arrIt() {
        column++;
        if (column >= data[row].length) {
            row++;
            column = 0;
        }
    }
}
