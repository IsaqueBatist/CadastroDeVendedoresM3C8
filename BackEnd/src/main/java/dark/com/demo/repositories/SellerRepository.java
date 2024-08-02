package dark.com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dark.com.demo.models.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
  
}
