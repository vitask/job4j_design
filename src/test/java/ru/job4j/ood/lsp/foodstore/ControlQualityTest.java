package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.Apple;
import ru.job4j.ood.lsp.foodstore.food.Cheese;
import ru.job4j.ood.lsp.foodstore.food.Food;
import ru.job4j.ood.lsp.foodstore.food.Tea;
import ru.job4j.ood.lsp.foodstore.store.Shop;
import ru.job4j.ood.lsp.foodstore.store.Store;
import ru.job4j.ood.lsp.foodstore.store.Trash;
import ru.job4j.ood.lsp.foodstore.store.WareHouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControlQualityTest {

    @Test
    void testDistributeToWareHouse() {
        WareHouse warehouse = new WareHouse();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse));
        LocalDate currentDate = LocalDate.now();
        Apple apple = new Apple("Apple", currentDate.plusDays(5),
                currentDate.minusDays(15), 10.0, 0.1);

        controlQuality.distribute(apple);

        assertEquals(1, warehouse.getProducts().size());
        assertEquals("Apple", warehouse.getProducts().get(0).getName());
    }

    @Test
    void testDistributeToShop() {
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(shop));
        LocalDate currentDate = LocalDate.now();
        Tea tea = new Tea("Tea", currentDate.plusDays(10),
                currentDate.minusDays(5), 8.0, 0.2);

        controlQuality.distribute(tea);

        assertEquals(1, shop.getProducts().size());
        assertEquals("Tea", shop.getProducts().get(0).getName());
    }

    @Test
    void testDistributeToTrash() {
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(trash));
        LocalDate currentDate = LocalDate.now();
        Cheese cheese = new Cheese("Cheese", currentDate.minusDays(1),
                currentDate.minusDays(10), 5.0, 0.1);

        controlQuality.distribute(cheese);

        assertEquals(1, trash.getProducts().size());
        assertEquals("Cheese", trash.getProducts().get(0).getName());
    }

    @Test
    public void testResort() {
        WareHouse warehouse = new WareHouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
        ControlQuality controlQuality = new ControlQuality(stores);
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDate = currentDate.plusDays(10);
        Food product = new Food("Test Product", expiryDate, currentDate, 100, 0);
        controlQuality.distribute(product);
        controlQuality.resort();
        assertEquals(0, shop.getProducts().size());
        assertEquals(1, warehouse.getProducts().size());
        assertEquals(0, trash.getProducts().size());
    }
}