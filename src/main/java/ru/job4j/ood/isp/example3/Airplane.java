package ru.job4j.ood.isp.example3;

public class Airplane implements Vehicle {
    @Override
    public void drive() {
        throw new RuntimeException("Самолет не ездит");
    }

    @Override
    public void fly() {
        System.out.println("Самолет летает");
    }

    @Override
    public void sail() {
        throw new RuntimeException("Самолет не плавает");
    }
}
