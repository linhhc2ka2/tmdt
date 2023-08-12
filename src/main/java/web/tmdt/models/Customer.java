package web.tmdt.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer implements Serializable {
    @Id
    @Column(name = "Customerid")
    private Integer customerId;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phonenumber")
    private String phoneNumber;

    @Column(name = "Createdat")
    private Date createAt = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<Order> order;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<Review> review;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<Wishlist> wishlist;
}
