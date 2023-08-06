package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Integer, String> preMap = new HashMap<>();
        for (User user : previous) {
            preMap.put(user.getId(), user.getName());
        }
        Map<Integer, String> curMap = new HashMap<>();
        for (User user : current) {
            curMap.put(user.getId(), user.getName());
            if (!preMap.containsKey(user.getId())) {
                added++;
            }
            if (preMap.containsKey(user.getId()) && !curMap.get(user.getId()).equals(preMap.get(user.getId()))) {
                changed++;
            }
            preMap.remove(user.getId());
        }
        return new Info(added, changed, preMap.size());
    }
}