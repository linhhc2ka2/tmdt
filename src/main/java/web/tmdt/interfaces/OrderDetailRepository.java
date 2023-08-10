package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
