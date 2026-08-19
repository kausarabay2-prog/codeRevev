package bitlab.kx.hiber.repository;

import bitlab.kx.hiber.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPriceBetween(double min, double max);
    List<Product> findByNameContainingIgnoreCase(String name);
}
