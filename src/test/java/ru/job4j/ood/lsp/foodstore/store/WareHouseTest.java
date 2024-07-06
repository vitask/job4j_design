package ru.job4j.ood.lsp.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.Tea;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WareHouseTest {
    @Test
    void testSupports() {
        WareHouse warehouse = new WareHouse();
        LocalDate currentDate = LocalDate.now();
        Tea tea = new Tea("Tea", currentDate.plusDays(15),
                currentDate.minusDays(5), 10.0, 0.1);
        boolean result = warehouse.supports(tea);
        assertTrue(result);
    }
}