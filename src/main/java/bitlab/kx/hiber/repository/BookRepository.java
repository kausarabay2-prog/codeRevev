package bitlab.kx.hiber.repository;
//ManyToOne
//OneToMany
import bitlab.kx.hiber.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
