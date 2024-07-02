package ru.job4j.ood.lsp;

/*
    Нарушение LSP, так как класс CardPayment меняет условия и выбрасывает исключение
 */

class Payment {
    void pay(double amount) {
        System.out.println("Payment for any amount");
    }
}

class CardPayment extends Payment {
    void pay(double amount) {
        if (amount > 1000) {
            throw new IllegalArgumentException("The amount is too large to pay with a card");
        }
    }
}
