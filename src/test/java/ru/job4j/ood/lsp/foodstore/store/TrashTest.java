package ru.job4j.ood.lsp.foodstore.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstore.food.Apple;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TrashTest {
    @Test
    void testSupports() {
        Trash trash = new Trash();
        LocalDate currentDate = LocalDate.now();
        Apple milk = new Apple("Apple", currentDate.minusDays(1),
                currentDate.minusDays(10), 10.0, 0.1);
        boolean result = trash.supports(milk);
        assertTrue(result);
    }
}