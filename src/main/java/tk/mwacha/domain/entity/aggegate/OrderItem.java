package tk.mwacha.domain.entity.aggegate;


import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;
@Getter
public class OrderItem {

    private UUID id;
    private UUID productId;
    private String name;
    private BigDecimal price;
    private int quantity;

    public OrderItem(UUID id, UUID productId, String name, BigDecimal price, int quantity) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal price() {
        return this.price.multiply(BigDecimal.valueOf(this.quantity));
    }
}
