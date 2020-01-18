package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.SellerSpecialties;
import pe.isil.model.SellerSpecialtyKey;

@Repository
public interface SellerSpecialtiesRepository
        extends JpaRepository<SellerSpecialties, SellerSpecialtyKey> {
}
