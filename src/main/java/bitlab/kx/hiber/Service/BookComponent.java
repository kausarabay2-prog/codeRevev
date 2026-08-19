package bitlab.kx.hiber.Service;

import bitlab.kx.hiber.Book;
import bitlab.kx.hiber.Library;
import bitlab.kx.hiber.repository.BookRepository;
import bitlab.kx.hiber.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookComponent {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    //GET ALL BOOK
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    //GET BOOK BY ID
    public  Book getById(Long id){
        return bookRepository.findById(id).orElse(null);

    }

    //ADD BOOK

    public void  add (String title,String aouthor,int price,Long libraryId){
        Library library = libraryRepository
                .findById(libraryId)
                .orElse(null);

        Book book = Book.builder().title(title)
                .author(aouthor)
                .price(price).
                build();
        bookRepository.save(book);
    }
    //UPDATE

    public  void update(Long id, String title, String author, int price,
                        Long librareId) {
        Book book = bookRepository.findById(id)
                .orElse(null);

        if (book != null) {
            Library library = libraryRepository.findById(librareId)
                    .orElse(null);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            book.setLibrary(library);
        }
    }

        //DELETE

        public void delete(Long id ){
            bookRepository.deleteById(id);
        }
    }

