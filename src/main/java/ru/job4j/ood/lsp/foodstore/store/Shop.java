package ru.job4j.ood.lsp.foodstore.store;

import ru.job4j.ood.lsp.foodstore.food.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Shop extends AbstractStore {

    @Override
    public boolean supports(Food product) {
        LocalDate currentDate = LocalDate.now();
        long daysToExpire = ChronoUnit.DAYS.between(currentDate, product.getExpiryDate());
        long shelfLife = ChronoUnit.DAYS.between(product.getCreateDate(), product.getExpiryDate());
        double discountThreshold = 0.75 * shelfLife;
        double freshnessThreshold = 0.25 * shelfLife;
        if (daysToExpire >= freshnessThreshold && daysToExpire <= discountThreshold) {
            return true;
        }
        if (daysToExpire > discountThreshold) {
            double newPrice = product.getPrice() * (1 - product.getDiscount() * 0.2);
            product.setPrice(newPrice);
            return true;
        }
        return false;
    }


    @Override
    public void clearProducts() {
        products = new ArrayList<>();
    }
}
