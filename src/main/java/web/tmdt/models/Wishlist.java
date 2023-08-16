package web.tmdt.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wishlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Wishlistid")
    private Integer wishlistID;

    @ManyToOne
    @JoinColumn(name = "Customerid")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "Productid")
    Product product;
}
