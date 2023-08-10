package web.tmdt.models;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "orderdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetail {
    @Id
    @Column(name = "Orderdetailid")
    private Integer orderDetailID;

    @ManyToOne
    @JoinColumn(name = "Orderid")
    Order order;

    @ManyToOne
    @JoinColumn(name = "Productid")
    Product product;

    @Column(name = "Quantity")
    private String quantity;

    @Column(name = "Subtotal")
    private String subtotal;
}
