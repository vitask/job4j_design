package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {
    private final int truckSize;

    public Truck(int truckSize) {
        this.truckSize = truckSize;
    }

    @Override
    public int size() {
        return this.truckSize;
    }
}
