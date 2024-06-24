package ru.job4j.ood.ocp;

public class Payment {
    public void paymentProcessor(String paymentType) {
        if (paymentType.equals("Qiwi")) {
            System.out.println("Выполняется обработка платежа с помощью системы Qiwi");
        } else if (paymentType.equals("Мир")) {
            System.out.println("Выполняется обработка платежа с помощью банковской карты Мир");
        }
    }
}
