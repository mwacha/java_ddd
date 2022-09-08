package tk.mwacha.infrastructure.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tk.mwacha.domain.entity.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductModel {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    public static Product to(ProductModel model) {
        return Product.builder().id(model.id).name(model.name).price(model.price).build();
    }

    public static ProductModel of(Product product) {
        return ProductModel.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).build();
    }

}
