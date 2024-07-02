package ru.job4j.ood.lsp;

/*
    Нарушение LSP, так как класс Chicken переопределяет метод fly
    и бросает исключение при вызове этого метода
 */

public class Bird {
    public void fly() {
        System.out.println("Bird is fly");
    }
}

class Chicken extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Chicken doesn't fly");
    }
}
