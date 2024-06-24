package ru.job4j.ood.ocp;

public class Calculator {
    public double calculate(double first, double second, String operation) {
        double result = 0;
        if (operation.equals("sum")) {
            result = first + second;
        } else if (operation.equals("subtract")) {
            result = first - second;
        } else if (operation.equals("multiply")) {
            result = first * second;
        }
        return result;
    }
}
