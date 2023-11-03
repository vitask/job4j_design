package ru.job4j.serialization.json;

import java.util.Arrays;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final boolean married;
    private final String[] workDay;
    private final Info info;

    public Employee(String firstName, String lastName, int age, boolean married, String[] workDay, Info info) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
        this.workDay = workDay;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", age=" + age
                + ", married=" + married
                + ", workDay=" + Arrays.toString(workDay)
                + ", info=" + info
                + '}';
    }
}
