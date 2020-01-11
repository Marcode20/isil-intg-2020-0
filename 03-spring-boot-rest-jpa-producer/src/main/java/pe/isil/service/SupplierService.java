package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Product;
import pe.isil.model.Supplier;
import pe.isil.repository.ProductRepository;
import pe.isil.repository.SupplierRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    ProductRepository productRepository;

    public void create(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void update(Supplier supplier){
        supplierRepository.save(supplier);
    }

    public void delete(Supplier supplier){
        supplierRepository.delete(supplier);
    }

    public List<Supplier> findAll(){
        return supplierRepository.findAll();
    }

    public Supplier findById(String ruc){
        return supplierRepository.findById(ruc)
                .orElseGet(null);
    }

    public List<Product> findSupplierId(String ruc) {
        return productRepository.findBySupplierRuc(ruc);
    }
}
