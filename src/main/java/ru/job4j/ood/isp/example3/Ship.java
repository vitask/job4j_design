package ru.job4j.ood.isp.example3;

public class Ship implements Vehicle {
    @Override
    public void drive() {
        throw new RuntimeException("Корабиль не ездит");
    }

    @Override
    public void fly() {
        throw new RuntimeException("Корабль не летает");
    }

    @Override
    public void sail() {
        System.out.println("Корабль плавает");
    }
}
