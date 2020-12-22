package brankosaponjic.springbootcrudexample.controller;

import brankosaponjic.springbootcrudexample.entity.Product;
import brankosaponjic.springbootcrudexample.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addAllProducts(@RequestBody List<Product> products) {
        return productService.saveAllProducts(products);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/productById/{id}")
    public Product getProductById(@PathVariable("id") int id ) {
        return productService.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product getProductByName(@PathVariable("name") String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
