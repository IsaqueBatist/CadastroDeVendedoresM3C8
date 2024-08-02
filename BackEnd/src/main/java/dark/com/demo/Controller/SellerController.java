package dark.com.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dark.com.demo.dto.SellerRequest;
import dark.com.demo.dto.SellerResponse;
import dark.com.demo.models.Seller;
import dark.com.demo.services.SellerService;

@RestController
@CrossOrigin
@RequestMapping("sellers")
public class SellerController {

  @Autowired
  private SellerService sellerService;

  @GetMapping
  public ResponseEntity<List<SellerResponse>> getSellers() {
    return ResponseEntity.ok(sellerService.getAllSellers());
  }

  @GetMapping("{id}")
  public ResponseEntity<SellerResponse> getSeller(@PathVariable Long id) {
    SellerResponse seller = sellerService.getDTOSellerById(id);
    return ResponseEntity.ok(seller);
  }

  @PostMapping
  public ResponseEntity<SellerResponse> save(@RequestBody @Valid SellerRequest sellerRequest) {
    SellerResponse sellerResponse = sellerService.saveSeller(sellerRequest);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(sellerResponse.getId())
        .toUri();

    return ResponseEntity.created(location).body(sellerResponse);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    sellerService.deleteSellerByID(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity<SellerResponse> update(@PathVariable Long id, @Valid @RequestBody Seller sellerUpdate) {
    sellerService.updateSeller(id, sellerUpdate);
    return ResponseEntity.ok().build();
  }

}
