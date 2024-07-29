package dark.com.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dark.com.demo.Models.Seller;

@RestController
public class SellerController {
  
  private List<Seller> sellers = Arrays.asList(
    new Seller(1L, "John Doe", 1000.0, 1),
    new Seller(2L, "Jane Doe", 2000.0, 0),
    new Seller(3L, "John Smith", 3000.0, 1),
    new Seller(4L, "Jane Smith", 4000.0, 0)
  );

  @GetMapping("/sellers")
  public List<Seller> getSellers(){
    return sellers;
  }

  @GetMapping("/sellers/{id}")
  public ResponseEntity<Seller> getSeller(@PathVariable Long id){
      Seller seller = sellers.stream()
                      .filter(s -> s.getId().equals(id))
                      .findFirst()
                      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));
      return ResponseEntity.ok(seller);
    }
}
