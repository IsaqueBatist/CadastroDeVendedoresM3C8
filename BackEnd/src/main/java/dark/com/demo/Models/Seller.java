package dark.com.demo.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dark.com.demo.dto.SellerResponse;

import javax.persistence.Column;

@Entity
@Table(name = "TBL_SELLERS")
public class Seller implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "salary")
  private Double salary;

  @Column(name = "bonus")
  private Double bonus;

  @Column(name = "gender")
  private Integer gender;

  public Seller() {
  }

  public Seller(Long id, String name, Double salary, Integer gender, Double bonus) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.gender = gender;
    this.bonus = bonus;
  }

  // Getters and setters

  public Double getBonus() {
    return bonus;
  }

  public void setBonus(Double bonus) {
    this.bonus = bonus;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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


  public SellerResponse toDTO() {
    SellerResponse sellerResponse = new SellerResponse();
    sellerResponse.setId(id);
    sellerResponse.setName(name);
    sellerResponse.setSalary(salary);
    sellerResponse.setGender(gender);
    sellerResponse.setBonus(bonus);
  
    return sellerResponse;
  }
}
