package dark.com.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import dark.com.demo.models.Seller;

public class SellerRequest {
  
  @NotBlank(message = "Name can't be blank")
  @Size(min = 3, max = 255, message = "name must have between 3 and 255 characters")
  private String name;

  @Min(value = 0, message = "Salary must be greater than 0")
  private Double salary;

  @Min(value = 1, message = "Gender must be 1 (Male) or 2 (Female)")
  @Max(value = 2, message = "Gender must be 1 (Male) or 2 (Female)")
  private Integer gender;

  @Min(value = 0, message = "Bonus must be greater than 0")
  @Max(value = 100, message = "Bonus must be less than 100")
  private Double bonus;


  // Getters and setters

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public Integer getGender() {
    return gender;
  }

  public void setGender(Integer gender) {
    this.gender = gender;
  }

  public Double getBonus() {
    return bonus;
  }

  public void setBonus(Double bonus) {
    this.bonus = bonus;
  }

  public Seller toEnity() {
    Seller seller = new Seller();
    seller.setName(name);
    seller.setSalary(salary);
    seller.setGender(gender);
    seller.setBonus(bonus);

    return seller;
  }
}
