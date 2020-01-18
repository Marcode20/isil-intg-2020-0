package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Specialty;

@Repository
public interface SpecialtyRepository
        extends JpaRepository<Specialty, Long> {
}
