package tk.mwacha;

import tk.mwacha.entity.Customer;
import tk.mwacha.entity.Order;
import tk.mwacha.entity.aggegate.OrderItem;
import tk.mwacha.valueobject.Address;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        // Customer Aggregate
        final var cutomerId = UUID.fromString("2302dee9-4037-48c0-8ed6-57c98ffe3997");
        final var cutomer = new Customer(cutomerId, "Marcelo Wacha");
        final var address = new Address("Rua um", 10, "12345-678", "Santa Catarina");
        cutomer.setAddress(address);
        cutomer.activate();

        // Order Aggregate
        final var item1 = new OrderItem(
                UUID.fromString("77de321a-d314-499e-ad45-5d647112cecc"), "Item1", BigDecimal.TEN);
        final var item2 = new OrderItem(
                UUID.fromString("fae9043e-ef3c-40ab-b8ca-af51e79eaffd"), "Item2", BigDecimal.valueOf(15));

        final var order = new Order(UUID.fromString("9222f3f4-e602-41bc-bfb5-7b2431c72d48"),
                cutomerId, List.of(item1, item2));

        System.out.println(order.total());
    }
}
