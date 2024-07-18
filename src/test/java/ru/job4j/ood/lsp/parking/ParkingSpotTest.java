package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingSpotTest {

    @Test
    void whenCanPark() {
        Vehicle car = new Car();
        ParkingInterface parking = new ParkingSpot(2, 1);
        assertTrue(parking.park(car));
    }

    @Test
    void whenCanNotPark() {
        Vehicle car = new Car();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(2);
        ParkingInterface parking = new ParkingSpot(1, 1);
        parking.park(car);
        parking.park(truck1);
        assertFalse(parking.park(truck2));
    }

    @Test
    void whenTruckParkToParkingSpot() {
        Vehicle car = new Car();
        Vehicle truck1 = new Truck(2);
        Vehicle truck2 = new Truck(2);
        ParkingInterface parking = new ParkingSpot(1, 2);
        parking.park(car);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }
}