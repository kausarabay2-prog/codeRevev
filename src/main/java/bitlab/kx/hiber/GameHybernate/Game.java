package bitlab.kx.hiber.GameHybernate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_game")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String genre;

    private double price;

}