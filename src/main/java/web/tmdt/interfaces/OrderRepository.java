package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
