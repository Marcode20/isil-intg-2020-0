package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_supplier")
public class Supplier {

    @Id
    private String ruc;
    @Column
    private String name;
    @Column
    private String contactEmail;
    @Column
    private String contactMobilePhone;
    @Column
    private String address;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

}
