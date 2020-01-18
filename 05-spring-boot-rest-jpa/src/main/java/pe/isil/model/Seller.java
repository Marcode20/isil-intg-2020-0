package pe.isil.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Seller extends Person {

    private Double monthlyQuota;
    private Double monthlyFee;

    @OneToMany(mappedBy = "seller")
    private Set<SellerSpecialties> sellerSpecialties;

}
