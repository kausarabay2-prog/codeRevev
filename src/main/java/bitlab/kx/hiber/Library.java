package bitlab.kx.hiber;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
//@Table(name = "t_Lybray")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "library")
    private List<Book> boos;
}