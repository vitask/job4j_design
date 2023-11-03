package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Company {
    public static void main(String[] args) {
        final Employee employee = new Employee("Oleg", "Petrov", 25, true,
                new String[]{"Monday", "Thursday", "Saturday"},
                new Info("Omsk", "+7(999)111-22-33", false));

        final Gson gson = new GsonBuilder().create();
        String gsonEmployee = gson.toJson(employee);
        System.out.println(gsonEmployee);

        final Employee employee1 = gson.fromJson(gsonEmployee, Employee.class);
        System.out.println(employee1);
    }

}
