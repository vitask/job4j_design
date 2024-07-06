package ru.job4j.ood.lsp.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.Apple;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShopTest {
    @Test
    public void whenProductAddWithDiscount() {
        Shop shop = new Shop();
        LocalDate expiryDate = LocalDate.now().plusDays(50);
        Apple apple = new Apple("Apple", LocalDate.now().minusDays(10), expiryDate, 80.0, 0.2);
        boolean result = shop.supports(apple);
        assertTrue(result);
        assertEquals(76.8, apple.getPrice(), 0.01);
    }
}