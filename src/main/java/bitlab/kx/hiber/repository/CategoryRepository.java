package bitlab.kx.hiber.repository;
//Anotation Service
import bitlab.kx.hiber.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}
