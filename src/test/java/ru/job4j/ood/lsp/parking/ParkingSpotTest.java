package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class ParkingSpotTest {

    @Test
    void whenCanPark() {
        Vehicle car = new Car();
        ParkingInterface parking = new ParkingSpot();
        assertTrue(parking.park(car));
    }

    @Test
    void whenCanNotPark() {
        Vehicle car = new Car();
        Vehicle truck1 = new Truck();
        Vehicle truck2 = new Truck();
        ParkingInterface parking = new ParkingSpot();
        parking.park(car);
        parking.park(truck1);
        assertFalse(parking.park(truck2));
    }

    @Test
    void whenTruckParkToParkingSpot() {
        Vehicle car = new Car();
        Vehicle truck1 = new Truck();
        Vehicle truck2 = new Truck();
        ParkingInterface parking = new ParkingSpot();
        parking.park(car);
        parking.park(truck1);
        assertTrue(parking.park(truck2));
    }
}