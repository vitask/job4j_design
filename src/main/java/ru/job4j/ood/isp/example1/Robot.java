package ru.job4j.ood.isp.example1;

public class Robot implements Worker {
    @Override
    public void work() {
        System.out.println("Робот работает");
    }

    @Override
    public void eat() {
       throw new RuntimeException("Роботу не нужно есть");
    }

    @Override
    public void sleep() {
        throw new RuntimeException("Роботу не нужно спать");
    }
}
