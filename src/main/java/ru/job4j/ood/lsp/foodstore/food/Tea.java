package ru.job4j.ood.lsp.foodstore.food;

import java.time.LocalDate;

public class Tea extends Food {
    public Tea(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
