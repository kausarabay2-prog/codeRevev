package bitlab.kx.hiber.Service;

import bitlab.kx.hiber.Product;
import bitlab.kx.hiber.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public List<Product>getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }
    public Product  getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public void  addProduct(Product product){
        productRepository.save(product);
    }
    public void updateProduct(Product product){
        productRepository.save(product);
    }
    public void delateProduct(Long id ){
        productRepository.findById(id);
    }

    public List<Product> search(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public List<Product> filterByPrice(double min,double max){
        return productRepository.findByPriceBetween(min, max);
    }
}
