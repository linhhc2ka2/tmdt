package web.tmdt.models;

import java.io.Serializable;
import java.util.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "Image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "Serviceid")
    Service service;

    @Column(name = "Sale")
    private Integer sale;

    @Column(name = "Sold")
    private Integer sold;

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
