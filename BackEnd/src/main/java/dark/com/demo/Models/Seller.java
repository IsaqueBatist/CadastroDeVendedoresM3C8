package dark.com.demo.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_SELLERS")
public class Seller implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  private Double salary;
  private Gender gender;

  public Seller() { }

  public Seller(int id, String name, Double salary, Gender gender){
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.gender = gender;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
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
  public Gender getGender() {
    return gender;
  }
  public void setGender(Gender gender) {
    this.gender = gender;
  }
}
