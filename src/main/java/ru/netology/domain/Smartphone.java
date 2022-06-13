package ru.netology.domain;

public class Smartphone extends Product {
  private String manufacturer;
  
  public Smartphone(int id, String name, long cost, String manufacturer) {
    super(id, name, cost);
    this.manufacturer = manufacturer;
  }
  
  @Override
  public boolean matches(String search) {
    if (!super.matches(search)) {
      if (manufacturer.contains(search)) {
        return true;
      }
      return false;
    }
    return true;
  }
}
