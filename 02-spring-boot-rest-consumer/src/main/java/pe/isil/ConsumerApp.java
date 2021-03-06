package pe.isil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import pe.isil.model.Product;

import java.net.URI;
import java.util.List;

@SpringBootApplication
public class ConsumerApp implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    private static final String ENDPOINT = "http://localhost:8081/api/products";

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Override
    public void run(String... args) throws Exception {
        addProduct();
        updateProduct();
        listProducts();
        deleteProduct();
    }

    private void addProduct(){

        Product product = new Product();
        product.setId(105);
        product.setSku("SKU00104");
        product.setName("corbatas");

        HttpEntity<Product> request = new HttpEntity<>(product);
        Product productResponse = restTemplate.postForObject(ENDPOINT, request, Product.class);
        System.out.println("productResponse = " + productResponse);

    }

    //actualizar
    private void updateProduct(){
        Product product = new Product(105, "SKU200","Zapatos");
        HttpEntity<Product> request = new HttpEntity<>(product);

        String UPDATE_ENDPOINT =  ENDPOINT +"/" + product.getId();
        restTemplate.exchange(UPDATE_ENDPOINT, HttpMethod.PUT, request, Void.class);

    }

    //delete
    private void deleteProduct(){
        String DELETE_URL = ENDPOINT +"/"+ 105;
        restTemplate.delete(DELETE_URL);
    }


    private void listProducts(){
        List products = restTemplate.getForObject(ENDPOINT, List.class);
        System.out.println("products = " + products);
    }

}
