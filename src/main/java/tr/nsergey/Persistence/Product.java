package tr.nsergey.Persistence;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private String location;

    public Product() {
    }

    public Product(String name, BigDecimal price, String location) {
        this.name = name;
        this.price = price;
        this.location = location;
    }
}