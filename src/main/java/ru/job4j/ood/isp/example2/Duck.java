package ru.job4j.ood.isp.example2;

public class Duck implements Bird {
    @Override
    public void eat() {
        System.out.println("Утка ест");
    }

    @Override
    public void laysEggs() {
        System.out.println("Утка откладывает яйца");
    }

    @Override
    public void fly() {
        System.out.println("Утка летает");
    }
}
