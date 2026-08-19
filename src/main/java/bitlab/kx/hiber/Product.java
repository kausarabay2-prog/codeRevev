package bitlab.kx.hiber;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Audited;

@Entity
@Audited.Table(name = "t_product")
@Data
@Builder
@AllArgsConstructor@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private double price;
    private int quantity;

}
