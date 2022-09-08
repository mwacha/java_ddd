package tk.mwacha.domain.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@EqualsAndHashCode
public class Product {

    private UUID id;
    private String name;
    private BigDecimal price;

    public Product(UUID id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    private void validate() {
        if (this.id == null) {
            throw new RuntimeException("Id is required");
        }

        if (this.name == null || this.name.isEmpty()) {
            throw new RuntimeException("Name is required");
        }

        if (this.price == null || this.price == BigDecimal.ZERO) {
            throw new RuntimeException("Price is required");
        }
    }

    public void changeName(final String name) {
        this.name = name;
        this.validate();
    }

    public void changePrice(final BigDecimal price) {
        this.price = price;
        this.validate();
    }
}
