package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entities.ProductCategory;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    Optional<ProductCategory> findByName(String name);
}
