package web.tmdt.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @Column(name = "Userid")
    private Integer userId;

    @Column(name = "Address")
    private String address;

    @Column(name = "Password")
    private String password;

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column(name = "Phonenumber")
    private String phoneNumber;

    @Column(name = "Createat")
    private Date createAt = new Date();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Banner> banner;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Coupon> coupon;
}
