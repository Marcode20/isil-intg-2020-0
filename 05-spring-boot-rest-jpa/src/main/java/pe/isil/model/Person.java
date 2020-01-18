package pe.isil.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class Person extends BaseEntity{

    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

}
