package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Supplier;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {

    //DB in memory
    List<Supplier> supplierList = new ArrayList<>();

    public void create(Supplier supplier){
        supplierList.add(supplier);
    }

    public void update(Supplier supplier){
        Supplier currentSupplier = findById(supplier.getRuc());
        int index = supplierList.indexOf(currentSupplier);
        supplierList.set(index, supplier);
    }

    public void delete(Supplier supplier){
        supplierList.remove(supplier);
    }

    public List<Supplier> findAll(){
        return supplierList;
    }

    public Supplier findById(String ruc){
        return supplierList.stream()
                .filter( e -> ruc.equalsIgnoreCase(e.getRuc()))
                .findFirst()
                .orElseGet(null);
    }

}
