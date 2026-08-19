package bitlab.kx.hiber;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "t_item")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "name_item")
    private String nameItem;
//
//    @Column(name = "price_item")
    private Double priceItem;

    @ManyToOne
//    @JoinColumn(name = "country_id")
    private Country country;
}