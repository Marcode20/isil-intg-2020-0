package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(100, "SKU00100","polo"),
                    new Product(101, "SKU00101","short"),
                    new Product(102, "SKU00102","camisa"),
                    new Product(103, "SKU00103","pantalon")
            )
            );

    public List<Product> getAll(){
        return products;
    }

    public void create (Product product){
        products.add(product);
    }

    public void delete(Product product){
        products.remove(product);
    }

    public void update(Product product){
       Product currentProduct  = findById(product.getId());
        int index = products.indexOf(currentProduct);
        products.set(index, product);
    }

    public Product findById(Integer id) {
        return products.stream()
                .filter(e -> id.equals(e.getId()))
                .findFirst()
                .orElse(null);
    }

}
