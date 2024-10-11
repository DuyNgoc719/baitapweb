package practices.baitap0710.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import practices.baitap0710.com.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}

