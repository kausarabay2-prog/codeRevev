package bitlab.kx.hiber;
//Anotation Service
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
//@Table(name = "t_car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String model;

    private int year;

    private double price;

    @ManyToOne
    private Country country;

    @ManyToMany
    private List<Category> categories;
}
