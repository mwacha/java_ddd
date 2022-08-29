package tk.mwacha.entity;

import org.junit.jupiter.api.Test;
import tk.mwacha.entity.aggegate.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

    @Test
    void should_throw_error_when_id_is_null() {

        assertThrows(RuntimeException.class, () -> {
            new Order(null, UUID.randomUUID(), List.of());
        }).getMessage().equals("Id is required");
    }

    @Test
    void should_throw_error_when_customer_id_is_null() {

        assertThrows(RuntimeException.class, () -> {
            new Order(UUID.randomUUID(), null, List.of());
        }).getMessage().equals("Customer Id is required");
    }

    @Test
    void should_throw_error_when_item_is_empty() {

        assertThrows(RuntimeException.class, () -> {
            new Order(UUID.randomUUID(), UUID.randomUUID(), List.of());
        }).getMessage().equals("Item qtd must be greater than zero");
    }

    @Test
    void should_calculate_total() {
        final var cutomerId = UUID.fromString("2302dee9-4037-48c0-8ed6-57c98ffe3997");

        final var item1 = new OrderItem(
                UUID.fromString("77de321a-d314-499e-ad45-5d647112cecc"), "Item1", BigDecimal.valueOf(100));

        final var item2 = new OrderItem(
                UUID.fromString("fae9043e-ef3c-40ab-b8ca-af51e79eaffd"), "Item2", BigDecimal.valueOf(200));


        final var order = new Order(UUID.fromString("9222f3f4-e602-41bc-bfb5-7b2431c72d48"),
                cutomerId, List.of(item1));

        final var total = order.total();
        assertEquals(total, BigDecimal.valueOf(100));

        final var order2 = new Order(UUID.fromString("9222f3f4-e602-41bc-bfb5-7b2431c72d48"),
                cutomerId, List.of(item1, item2));

        final var total2 = order2.total();

        assertEquals(total2, BigDecimal.valueOf(300));

    }
}