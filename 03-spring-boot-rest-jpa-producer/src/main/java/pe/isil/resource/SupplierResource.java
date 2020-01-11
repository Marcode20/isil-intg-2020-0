package pe.isil.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Product;
import pe.isil.model.Supplier;
import pe.isil.service.ProductService;
import pe.isil.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductService productService;

    @GetMapping("/suppliers")
    public ResponseEntity findAll(){
        List<Supplier> supplierList = supplierService.findAll();
        if(supplierList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(supplierList, HttpStatus.OK);
    }

    @GetMapping("/suppliers/{ruc}")
    public ResponseEntity findById(@PathVariable String ruc){

        Supplier currentSupplier = supplierService.findById(ruc);
        if(currentSupplier == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(currentSupplier, HttpStatus.OK);
    }

    @PostMapping("/suppliers")
    public ResponseEntity create(@RequestBody Supplier supplier){
        supplierService.create(supplier);
        return new ResponseEntity(supplier, HttpStatus.CREATED);
    }

    @PutMapping("/suppliers/{ruc}")
    public ResponseEntity update(@PathVariable String ruc,
                                 @RequestBody Supplier supplier){

        Supplier currentSupplier = supplierService.findById(ruc);
        if(currentSupplier == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        supplier.setRuc(ruc);
        supplierService.update(supplier);
        return new ResponseEntity(supplier, HttpStatus.OK);
    }

    @DeleteMapping("/suppliers/{ruc}")
    public ResponseEntity delete(@PathVariable String ruc){

        Supplier currentSupplier = supplierService.findById(ruc);
        if(currentSupplier == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        supplierService.delete(currentSupplier);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/suppliers/{ruc}/products")
    public ResponseEntity getAllProductsBySupplierId(@PathVariable String ruc){
        List<Product> products = supplierService.findSupplierId(ruc);
        if(products.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping("/suppliers/{ruc}/products")
    public ResponseEntity createProduct(@PathVariable String ruc,
                                        @RequestBody Product product){
        Supplier currentSupplier = supplierService.findById(ruc);
        product.setSupplier(currentSupplier);
        productService.create(product);
        return new ResponseEntity(product, HttpStatus.CREATED);
    }

    @PutMapping("/suppliers/{ruc}/products/{id}")
    public ResponseEntity createProduct(@PathVariable String ruc,
                                        @PathVariable Integer id,
                                        @RequestBody Product product){
        Supplier currentSupplier = supplierService.findById(ruc);

        if(currentSupplier == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Product currentProduct = currentSupplier.getProducts().stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst().orElseGet(null);

        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        //product.setSupplier(currentSupplier);
        productService.update(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping("/suppliers/{ruc}/products/{id}")
    public ResponseEntity createProduct(@PathVariable String ruc,
                                        @PathVariable Integer id){
        Supplier currentSupplier = supplierService.findById(ruc);

        if(currentSupplier == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Product currentProduct = currentSupplier.getProducts().stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst().orElseGet(null);

        if(currentProduct == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        productService.delete(currentProduct);

        return new ResponseEntity(HttpStatus.OK);
    }

}
