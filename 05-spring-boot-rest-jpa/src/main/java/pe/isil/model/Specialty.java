package pe.isil.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Specialty
        extends NamedEntity {

    @OneToMany(mappedBy = "specialty")
    private Set<SellerSpecialties> sellerSpecialties;
}
