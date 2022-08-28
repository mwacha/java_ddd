package tk.mwacha.entity;

import tk.mwacha.entity.aggegate.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private UUID customerId;
    private List<OrderItem> items;


    public Order(final UUID id, final UUID customerId, final List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
    }

    public BigDecimal total() {
       return this.items.stream().map(i -> i.getPrice()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

}
