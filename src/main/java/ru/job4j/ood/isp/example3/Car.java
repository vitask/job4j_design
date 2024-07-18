package ru.job4j.ood.isp.example3;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Машина едет");
    }

    @Override
    public void fly() {
        throw new RuntimeException("Машина не летает");
    }

    @Override
    public void sail() {
        throw new RuntimeException("Машина не плавает");
    }
}
