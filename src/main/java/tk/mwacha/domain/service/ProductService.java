package tk.mwacha.domain.service;

import java.math.BigDecimal;
import java.util.List;
import tk.mwacha.domain.entity.Product;

public class ProductService {

  public void increasePrice(final List<Product> products, final int percentage) {
    products.stream()
        .forEach(
            p ->
                p.changePrice(
                    p.getPrice()
                        .multiply(BigDecimal.valueOf(percentage))
                        .divide(BigDecimal.valueOf(100))
                        .add(p.getPrice())));
  }
}
