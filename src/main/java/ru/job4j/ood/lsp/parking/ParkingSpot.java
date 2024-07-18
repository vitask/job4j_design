package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpot implements ParkingInterface {
    private int carSpot;
    private int truckSpot;
    private final List<Vehicle> vehicles = new ArrayList<>();

    public ParkingSpot(int carSpot, int truckSpot) {
        this.carSpot = carSpot;
        this.truckSpot = truckSpot;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean result = false;
        int vehicleSize = vehicle.size();
        if (vehicleSize == 1 && this.carSpot > 0) {
            this.carSpot--;
            vehicles.add(vehicle);
            result = true;
        } else if (vehicleSize > 1 && this.truckSpot > 0) {
            this.truckSpot--;
            vehicles.add(vehicle);
            result = true;
        } else if (vehicleSize <= this.carSpot) {
            this.carSpot -= vehicleSize;
            vehicles.add(vehicle);
            result = true;
        }
        return result;
    }
}
