package web.tmdt.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import web.tmdt.models.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

}
