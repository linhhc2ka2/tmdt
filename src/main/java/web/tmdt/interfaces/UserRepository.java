package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.*;

import web.tmdt.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT o FROM User o WHERE o.email = ?1")
    User findByUserEmail(String email);
}
