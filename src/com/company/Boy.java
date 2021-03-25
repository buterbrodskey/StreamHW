package com.company;

import java.util.Objects;

public class Boy {
    private final String name;
    private final int age;

    Boy(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return getAge() >= 18;
    }

    public boolean nameSake(Boy boy) {
        return getName().equals(boy.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boy boy = (Boy) o;
        return age == boy.age && Objects.equals(name, boy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + "-" + age;
    }
}
