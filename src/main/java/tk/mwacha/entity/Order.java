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

        validate();
    }

    public BigDecimal total() {
       return this.items.stream().map(i -> i.getPrice()).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }


    private void validate() {

        if (this.id == null) {
            throw new RuntimeException("Id is required");
        }

        if (this.customerId == null) {
            throw new RuntimeException("Customer Id is required");
        }

        if (this.items == null || this.items.isEmpty()) {
            throw new RuntimeException("Item qtd must be greater than zero");
        }

    }

}
