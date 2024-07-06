package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

import java.util.List;

public interface Store {
    void addProduct(Food product);

    boolean supports(Food product);

    List<Food> getProducts();

    void clearProducts();
}