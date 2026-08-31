package bitlab.kx.hiber.Service;
//ManyToOne
//OneToMany
import bitlab.kx.hiber.Library;
import bitlab.kx.hiber.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LibraryComponent {
    private final LibraryRepository libraryRepository;

    // GET ALL
    public List<Library> getAll(){
        return libraryRepository.findAll();
    }

    // GET BY ID
    public Library getById(Long id){
        return libraryRepository.findById(id).orElse(null);
    }

    // ADD
    public void add(String name, String address){
        Library library = Library.builder()
                .name(name)
                .address(address)
                .build();
        libraryRepository.save(library);
    }

    // UPDATE
    public void update(Long id, String name, String address){
        Library library = libraryRepository.findById(id).orElse(null);
        if (library != null){
            library.setName(name);
            library.setAddress(address);
            libraryRepository.save(library);
        }
    }

    // DELETE
    public void delete(long id){
        libraryRepository.deleteById(id);
    }
}