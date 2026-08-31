package bitlab.kx.hiber.repository;
import bitlab.kx.hiber.Car;
import org.springframework.data.jpa.repository.JpaRepository;
//Anotation Service
public interface CarRepository
        extends JpaRepository<Car, Long> {
}