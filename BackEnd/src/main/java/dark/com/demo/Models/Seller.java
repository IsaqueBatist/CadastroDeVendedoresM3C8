package dark.com.demo.Models;

public class Seller {
  
  private Long id;
  private String name;
  private Double salary;
  private Integer gender;

  public Seller() { }

  public Seller(Long id, String name, Double salary, Integer gender){
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.gender = gender;
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
}
