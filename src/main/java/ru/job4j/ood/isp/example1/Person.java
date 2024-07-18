package ru.job4j.ood.isp.example1;

public class Person implements Worker {
    @Override
    public void work() {
        System.out.println("Человек работает");
    }

    @Override
    public void eat() {
        System.out.println("Человек ест");
    }

    @Override
    public void sleep() {
        System.out.println("Человек спит");
    }
}
