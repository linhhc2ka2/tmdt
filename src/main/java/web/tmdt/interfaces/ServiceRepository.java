package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
