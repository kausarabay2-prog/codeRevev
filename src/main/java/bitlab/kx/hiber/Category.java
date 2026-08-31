package bitlab.kx.hiber;
//Anotation Service
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
