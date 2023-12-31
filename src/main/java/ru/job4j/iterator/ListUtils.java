package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index);
                iterator.add(value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index + 1);
                iterator.add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        if (list.size() > 0 || filter != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                T element = it.next();
                if (filter.test(element)) {
                    it.remove();
                }
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> it = list.listIterator();
            while (it.hasNext()) {
                if (filter.test(it.next())) {
                    it.set(value);
                }
            }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        removeIf(list, elements::contains);
    }

}