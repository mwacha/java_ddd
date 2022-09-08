package tk.mwacha.infrastructure.service.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tk.mwacha.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    void should_create_a_product() {
        final var id = UUID.randomUUID();
        final var product = Product.builder()
                .id(id)
                .name("Test")
                .price(BigDecimal.valueOf(100)).build();

        service.create(product);

        final var productModel = service.find(id);

        assertThat(product)
                .usingRecursiveComparison()
                .ignoringFields("id", "name", "price")
                .isEqualTo(productModel);

    }

    @Test
    void should_update_a_product() {
        final var id = UUID.randomUUID();
        final var product = Product.builder()
                .id(id)
                .name("Test")
                .price(BigDecimal.valueOf(100)).build();

        service.create(product);

        final var productModel = service.find(id);

        assertThat(product)
                .usingRecursiveComparison()
                .ignoringFields("id", "name", "price")
                .isEqualTo(productModel);

        final var productPersisted =productModel;

        productPersisted.changeName("Teste 2");
        productPersisted.changePrice(BigDecimal.valueOf(200));

        service.create(productPersisted);

        final var productModelUpdated = service.find(id);

        assertThat(productPersisted)
                .usingRecursiveComparison()
                .ignoringFields("id", "name", "price")
                .isEqualTo(productModelUpdated);
    }

    @Test
    void should_find_a_product() {
        final var id = UUID.randomUUID();
        final var product = Product.builder()
                .id(id)
                .name("Test")
                .price(BigDecimal.valueOf(100)).build();

        service.create(product);

        final var productModel = service.find(id);

        assertThat(product)
                .usingRecursiveComparison()
                .ignoringFields("id", "name", "price")
                .isEqualTo(productModel);
    }


    @Test
    void should_find_all_product() {

        final var product = Product.builder()
                .id(UUID.randomUUID())
                .name("Test")
                .price(BigDecimal.valueOf(100)).build();

        final var product2 = Product.builder()
                .id(UUID.randomUUID())
                .name("Test2")
                .price(BigDecimal.valueOf(200)).build();
        final var products = List.of(product, product2);

        service.createAll(products);

        final var foundProducts = service.findAll();


        Assertions.assertIterableEquals(products, foundProducts);

    }

}
