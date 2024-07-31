package dark.com.demo.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dark.com.demo.Models.Seller;

@RestController
@CrossOrigin
public class SellerController {
  
  private List<Seller> sellers = new ArrayList<Seller>();
  // private List<Seller> sellers = Arrays.asList(
  //   new Seller(1, "John Doe", 1000.0, 1),
  //   new Seller(2, "Jane Doe", 2000.0, 0),
  //   new Seller(3, "John Smith", 3000.0, 1),
  //   new Seller(4, "Jane Smith", 4000.0, 0)
  // );

  @GetMapping("sellers")
  public List<Seller> getSellers(){
    return sellers;
  }

  @GetMapping("sellers/{id}")
  public ResponseEntity<Seller> getSeller(@PathVariable Long id){
      Seller seller = sellers.stream()
                      .filter(s -> s.getId() == id)
                      .findFirst()
                      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));
      return ResponseEntity.ok(seller);
    }

    @PostMapping("sellers")
    public ResponseEntity<Seller> save(@RequestBody Seller seller){
      seller.setId(Long.valueOf(sellers.size() + 1));
      sellers.add(seller);

      URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(seller.getId())
        .toUri();

    return ResponseEntity.created(location).body(seller);
    }
  
    @DeleteMapping("sellers/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
      Seller seller = sellers.stream()
                      .filter(s -> s.getId() == id)
                      .findFirst()
                      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));
      sellers.remove(seller);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("sellers/{id}")
    public ResponseEntity<Seller> update(@PathVariable Long id, @RequestBody Seller sellerUpdate){
      Seller newSellerInfo = sellers.stream()
                      .filter(s -> s.getId() == id)
                      .findFirst()
                      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));
      newSellerInfo.setName(sellerUpdate.getName());
      newSellerInfo.setSalary(sellerUpdate.getSalary());
      newSellerInfo.setGender(sellerUpdate.getGender());
      return ResponseEntity.ok(newSellerInfo);
    }
  
}
