package tk.mwacha.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import tk.mwacha.infrastructure.database.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {}
