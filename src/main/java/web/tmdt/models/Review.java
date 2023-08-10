package web.tmdt.models;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {
    @Id
    @Column(name = "Reviewid")
    private Integer reviewID;

    @ManyToOne
    @JoinColumn(name = "Productid")
    Product product;

    @ManyToOne
    @JoinColumn(name = "Customerid")
    Customer customer;

    @Column(name = "Rating")
    private String rating;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Createdat")
    private Date createAt = new Date();
}
