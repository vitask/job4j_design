package ru.job4j.ood.lsp.foodstore;

import ru.job4j.ood.lsp.foodstore.food.Food;
import ru.job4j.ood.lsp.foodstore.store.Store;

import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribute(Food food) {
        stores.stream()
                .filter(store -> store.supports(food))
                .findFirst()
                .ifPresent(store -> store.addProduct(food));
    }

    public void resort() {
        List<Food> foodList = stores.stream()
                .flatMap(s -> s.getProducts().stream())
                .toList();
        stores.forEach(Store::clearProducts);
        foodList.forEach(this::distribute);
    }
}
