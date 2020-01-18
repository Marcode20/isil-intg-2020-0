package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Seller;

@Repository
public interface SellerRepository
        extends JpaRepository<Seller, Long> {
}
