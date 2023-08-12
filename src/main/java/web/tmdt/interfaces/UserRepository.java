package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
