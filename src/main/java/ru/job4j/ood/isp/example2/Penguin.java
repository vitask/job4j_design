package ru.job4j.ood.isp.example2;

public class Penguin implements Bird {
    @Override
    public void eat() {
        System.out.println("Пингвит ест");
    }

    @Override
    public void laysEggs() {
        System.out.println("Пингвин откладывает яйца");
    }

    @Override
    public void fly() {
        throw new RuntimeException("Пингвин не умеет летать");
    }
}
