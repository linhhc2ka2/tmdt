package web.tmdt.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product implements Serializable {
    @Id
    @Column(name = "Productid")
    private Integer productId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Quantityinstock")
    private Integer quantityInStock;

    @ManyToOne
    @JoinColumn(name = "Categoryid")
    Category category;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Createat")
    private Date createAt = new Date();

    @Column(name = "Updateat")
    private Date updateAt = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetail;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Review> review;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Wishlist> wishlist;
}
