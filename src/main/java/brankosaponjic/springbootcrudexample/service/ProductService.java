package brankosaponjic.springbootcrudexample.service;

import brankosaponjic.springbootcrudexample.entity.Product;
import brankosaponjic.springbootcrudexample.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
         return productRepository.save(product);
    }

    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(int id, Product newProduct) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(prod -> prod.setName(newProduct.getName()));
        product.ifPresent(prod -> prod.setQuantity(newProduct.getQuantity()));
        product.ifPresent(prod -> prod.setPrice(newProduct.getPrice()));
        product.ifPresent(prod -> productRepository.save(prod));
    }
}
