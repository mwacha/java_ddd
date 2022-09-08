package tk.mwacha.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.mwacha.infrastructure.database.model.ProductModel;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
