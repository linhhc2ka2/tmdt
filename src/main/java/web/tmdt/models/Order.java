package web.tmdt.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "Orderid")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "Customerid")
    Customer customer;

    @Column(name = "Orderdate")
    private String orderDate;

    @Column(name = "Totalamount")
    private String totalAmount;

    @Column(name = "Shippingaddress")
    private String shippingAddress;

    @Column(name = "Paymentmethod")
    private String paymentMethod;

    @Column(name = "Orderstatus")
    private String orderStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetail;
}
