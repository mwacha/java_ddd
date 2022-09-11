package tk.mwacha.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import tk.mwacha.infrastructure.database.model.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, UUID> {}
