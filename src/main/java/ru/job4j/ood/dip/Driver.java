package ru.job4j.ood.dip;
    /*
    Класс Driver напрямую зависит от конкретной реализации
    ToyotaCar в своем конструкторе, что делает его привязанным только
    к одной марке автомобиля
    */
public class Driver {
    private ToyotaCar car;

    public Driver(ToyotaCar car) {
        this.car = car;
    }

    public void drive() {
        car.drive();
    }
}
