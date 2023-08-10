package web.tmdt.models;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wishlist {
    @Id
    @Column(name = "Wishlistid")
    private Integer wishlistID;

    @ManyToOne
    @JoinColumn(name = "Customerid")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "Productid")
    Product product;
}
