package dark.com.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dark.com.demo.models.Seller;
import dark.com.demo.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired  
  private SellerRepository sellerRepository;
  

  public Seller getSellerById(Long id){
    Seller seller = sellerRepository.findById(id)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));
    return seller;
  }

  public List<Seller> getAllSellers(){
    return sellerRepository.findAll();
  }

  public Seller saveSeller(Seller seller){
    if(seller.getGender() != 1 && seller.getGender() != 2){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Gender");
    }
    return sellerRepository.save(seller);
  }

  public void deleteSellerByID(Long id){
    sellerRepository.deleteById(id);
  }

  public void updateSeller(Long id, Seller sellerUpdate){
    Seller seller = getSellerById(id);

    if(sellerUpdate.getGender() != 1 && sellerUpdate.getGender() != 2){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Gender");
    }

    seller.setName(sellerUpdate.getName());
    seller.setSalary(sellerUpdate.getSalary());
    seller.setGender(sellerUpdate.getGender());

    sellerRepository.save(seller);
  }

}
