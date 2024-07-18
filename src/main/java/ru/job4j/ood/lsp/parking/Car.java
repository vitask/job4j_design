package ru.job4j.ood.lsp.parking;

public class Car implements Vehicle {
    private final int carSize;

    public Car() {
        this.carSize = 1;
    }

    @Override
    public int size() {
        return this.carSize;
    }
}
