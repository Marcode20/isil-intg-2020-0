package pe.isil.model;


import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class NamedEntity
        extends BaseEntity{
    private String name;

}
