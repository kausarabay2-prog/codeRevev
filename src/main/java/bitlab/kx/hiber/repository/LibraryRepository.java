package bitlab.kx.hiber.repository;
//ManyToOne
//OneToMany
import bitlab.kx.hiber.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {
}
