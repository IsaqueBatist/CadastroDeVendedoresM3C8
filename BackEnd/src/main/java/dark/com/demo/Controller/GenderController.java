package dark.com.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dark.com.demo.Models.Gender;

@RestController
public class GenderController {

  // private List<Gender> genders = new ArrayList<Gender>();
  private List<Gender> genders = Arrays.asList(
    new Gender(1, "Masculino"),
    new Gender(2, "Feminino")
  );

  @GetMapping("genders")
  private List<Gender> getGenders() {
    return genders;
  }

  @GetMapping("genders/{id}")
  private ResponseEntity<Gender> getGender(@PathVariable Long id) {
    Gender gender = genders.stream()
        .filter(s -> s.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));
    return ResponseEntity.ok(gender);
  }
}
