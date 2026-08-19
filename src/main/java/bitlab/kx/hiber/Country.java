package bitlab.kx.hiber;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "t_country")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

}