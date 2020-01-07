package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Supplier {

    private String ruc;
    private String name;
    private String contactEmail;
    private String contactMobilePhone;
    private String address;

}
