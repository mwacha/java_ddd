package tk.mwacha.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import tk.mwacha.infrastructure.database.model.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, UUID> {}
