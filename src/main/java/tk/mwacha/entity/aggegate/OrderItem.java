package tk.mwacha.entity.aggegate;


import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {

    private UUID id;
    private String name;
   @Getter
    private BigDecimal price;


    public OrderItem(final UUID id, final String name, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
