package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Product;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

}
