package pe.isil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.model.Product;
import pe.isil.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public void create (Product product){
        productRepository.save(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

    public void update(Product product){
       productRepository.save(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseGet(null);
    }

}
