package tk.mwacha.domain.repository;

import java.util.List;
import java.util.UUID;

public interface Repository<T> {

    void create (T entity);
    void update (T entity);
    T find (UUID id);
    List<T> findAll();
}
