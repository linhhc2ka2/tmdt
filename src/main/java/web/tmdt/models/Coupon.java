package web.tmdt.models;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coupon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Couponid")
    private Integer couponId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "Userid")
    User user;
}
