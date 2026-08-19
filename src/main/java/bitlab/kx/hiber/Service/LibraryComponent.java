package bitlab.kx.hiber.Service;

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
    //GET BY ID

    public Library getById(Long id ){
        return libraryRepository
                .findById(id)
                .orElse(null);
    }

    //ADD

    public void add(String name, String adress){
        Library library = Library.builder()
                .name(name)
                .adress(adress)
                .build();
    }
    //UPDATE

    public void  update(Long id,
                        String name,
                        String adress){
        Library library = libraryRepository
                .findById(id)
                .orElse(null);
        if (library != null){
            library.setName(name);
            library.setAdress(adress);
        }
    }
    //DELETE
    public  void delete(long id){
        libraryRepository.deleteById(id);
    }
}
