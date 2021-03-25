package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final ArrayList<Boy> boys = new ArrayList<>() {{
        add(new Boy("Николай", 68));
        add(new Boy("Пётр", 53));
        add(new Boy("Василий", 25));
        add(new Boy("Михаил", 19));
        add(new Boy("Алексей", 6));
        add(new Boy("Николай", 86));
        add(new Boy("Пётр", 35));
        add(new Boy("Михаил", 111));
        add(new Boy("Алексей", 22));
        add(new Boy("Михаил", 1));
        add(new Boy("Яков", 30));
    }};

    public static void main(String[] args) {
        Set<String> uniqueNames = new HashSet<>();
        Map<String, Integer> map = boys.stream()
                .filter(Boy::isAdult)
                .filter(boy -> uniqueNames.add(boy.getName()))
                .sorted(Comparator.comparing(Boy::getName))
                .limit(4)
                .collect(Collectors.toMap(Boy::getName,
                        Main::countNameSakeBoys,
                        (oldValue, newValue) -> newValue,
                        LinkedHashMap::new));
    }

    private static int countNameSakeBoys(Boy boy) {
        return (int) boys.stream()
                .filter(boy::nameSake)
                .count();
    }
}
