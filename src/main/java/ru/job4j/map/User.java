package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Oleg", 2, new GregorianCalendar(1980, Calendar.FEBRUARY, 3));
        User user2 = new User("Oleg", 2, new GregorianCalendar(1980, Calendar.FEBRUARY, 3));
        Map<User, Object> userObjectMap = new HashMap<>(16);
        userObjectMap.put(user1, new Object());
        userObjectMap.put(user2, new Object());
        for (Map.Entry map : userObjectMap.entrySet()) {
            System.out.println(map);
        }
    }
}
