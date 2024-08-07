package dark.com.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import dark.com.demo.dto.SellerRequest;
import dark.com.demo.dto.SellerResponse;
import dark.com.demo.models.Seller;
import dark.com.demo.repositories.SellerRepository;

@Service
public class SellerService {

  @Autowired
  private SellerRepository sellerRepository;

  public SellerResponse getSellerById(Long id) {
    Seller seller = sellerRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Seller not found"));
    return seller.toDTO();
  }

  public List<SellerResponse> getAllSellers() {
    return sellerRepository.findAll()
        .stream()
        .map(s -> s.toDTO())
        .collect(Collectors.toList());
  }

  public SellerResponse saveSeller(SellerRequest sellerRequest) {
      Seller sellerEntity = sellerRepository.save(sellerRequest.toEnity());
      return sellerEntity.toDTO();
  }

  public void deleteSellerByID(Long id) {
    try {
      sellerRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new EntityNotFoundException("Seller not found");
    }
  }

  @Transactional
  public void updateSeller(Long id, SellerRequest sellerUpdate) {
    try {
      Seller seller = sellerRepository.getReferenceById(id);
      seller.setName(sellerUpdate.getName());
      seller.setSalary(sellerUpdate.getSalary());
      seller.setGender(sellerUpdate.getGender());
      seller.setBonus(sellerUpdate.getBonus());
      sellerRepository.save(seller);
    } catch (EntityNotFoundException e) {
      throw new EntityNotFoundException("Seller not found");
    }
  }

}
