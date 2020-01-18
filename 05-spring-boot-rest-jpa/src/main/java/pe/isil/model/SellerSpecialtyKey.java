package pe.isil.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
@Data
public class SellerSpecialtyKey implements Serializable {

    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "specialty_id")
    private Long specialtyId;

}
