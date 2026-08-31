package bitlab.kx.hiber;
//ManyToOne
//OneToMany
import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "t_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "library_id")
    private Library library;
}