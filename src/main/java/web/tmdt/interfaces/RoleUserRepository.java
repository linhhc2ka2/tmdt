package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.RoleUser;

public interface RoleUserRepository extends JpaRepository<RoleUser, Integer> {

}
