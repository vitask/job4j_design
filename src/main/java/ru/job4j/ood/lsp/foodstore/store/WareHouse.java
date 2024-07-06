package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class WareHouse extends AbstractStore {
    @Override
    public boolean supports(Food product) {
        LocalDate currentDate = LocalDate.now();
        long daysToExpire = ChronoUnit.DAYS.between(product.getExpiryDate(), currentDate);
        long shelfLife = ChronoUnit.DAYS.between(product.getCreateDate(), product.getExpiryDate());
        return daysToExpire < 0.25 * shelfLife;
    }

    @Override
    public void clearProducts() {
        products = new ArrayList<>();
    }
}
