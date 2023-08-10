package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
