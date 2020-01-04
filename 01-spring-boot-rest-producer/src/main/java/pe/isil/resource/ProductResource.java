package pe.isil.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Product;
import pe.isil.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAll(){

        List<Product> products = productService.getAll();
        if(products == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity create(@RequestBody Product product){
        productService.create(product);
        return new ResponseEntity(product, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Product product){

        Product currentProduct = productService.findById(id);
        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        product.setId(id);
        productService.update(product);

        return new ResponseEntity(product,HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        Product currentProduct = productService.findById(id);
        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        productService.delete(currentProduct);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Product currentProduct = productService.findById(id);
        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(currentProduct, HttpStatus.OK);
    }

}
