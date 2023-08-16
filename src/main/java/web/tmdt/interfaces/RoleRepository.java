package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
