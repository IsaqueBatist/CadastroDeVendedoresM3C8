package dark.com.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dark.com.demo.models.Seller;
import dark.com.demo.services.SellerService;

@RestController
@RequestMapping("sellers")
public class SellerController {

  @Autowired
  private SellerService sellerService;


  @GetMapping
  public ResponseEntity<List<Seller>> getSellers(){
    return ResponseEntity.ok(sellerService.getAllSellers());
  }

  @GetMapping("{id}")
  public ResponseEntity<Seller> getSeller(@PathVariable Long id){
      Seller seller = sellerService.getSellerById(id);
      return ResponseEntity.ok(seller);
    }

    @PostMapping
    public ResponseEntity<Seller> save(@RequestBody Seller seller){
      seller = sellerService.saveSeller(seller);

      URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(seller.getId())
        .toUri();

    return ResponseEntity.created(location).body(seller);
    }
  
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
      sellerService.deleteSellerByID(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Seller> update(@PathVariable Long id, @RequestBody Seller sellerUpdate){
      sellerService.updateSeller(id, sellerUpdate);
      return ResponseEntity.ok().build();
    }
  
}
