package pe.isil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.model.Seller;
import pe.isil.model.SellerSpecialties;
import pe.isil.model.SellerSpecialtyKey;
import pe.isil.model.Specialty;
import pe.isil.repository.SellerRepository;
import pe.isil.repository.SellerSpecialtiesRepository;
import pe.isil.repository.SpecialtyRepository;

import java.time.LocalDate;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerSpecialtiesRepository sellerSpecialtiesRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Specialty specialty = new Specialty();
        specialty.setName("Technology");
        Specialty specialtySaved1 = specialtyRepository.save(specialty);

        specialty = new Specialty();
        specialty.setName("Software Engineer");
        Specialty specialtySaved2 = specialtyRepository.save(specialty);

        Seller seller = new Seller();
        seller.setFirstName("Jose");
        seller.setLastNameFather("Ventura");
        seller.setLastNameMother("Arteaga");
        seller.setBirthDate(LocalDate.of(1985, 3, 31));
        seller.setMonthlyQuota(10000.0);
        seller.setMonthlyFee(1000.0);

        Seller sellerSaved = sellerRepository.save(seller);

        SellerSpecialtyKey key = new SellerSpecialtyKey();
        key.setSpecialtyId(specialtySaved1.getId());
        key.setSellerId(sellerSaved.getId());

        SellerSpecialties sellerSpecialties = new SellerSpecialties();
        sellerSpecialties.setId(key);
        sellerSpecialties.setCreatedDate(LocalDate.now());

        sellerSpecialtiesRepository.save(sellerSpecialties);


        key = new SellerSpecialtyKey();
        key.setSpecialtyId(specialtySaved2.getId());
        key.setSellerId(sellerSaved.getId());

        sellerSpecialties = new SellerSpecialties();
        sellerSpecialties.setId(key);
        sellerSpecialties.setCreatedDate(LocalDate.now());

        sellerSpecialtiesRepository.save(sellerSpecialties);

    }
}
