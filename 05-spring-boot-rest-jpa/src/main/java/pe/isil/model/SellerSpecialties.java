package pe.isil.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class SellerSpecialties {

    @EmbeddedId
    private SellerSpecialtyKey id;

    @ManyToOne
    @MapsId("seller_id")
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @MapsId("specialty_id")
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    private LocalDate createdDate;

}
