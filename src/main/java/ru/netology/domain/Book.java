package ru.netology.domain;

public class Book extends Product {
  private String author;
  
  public Book(int id, String name, long cost, String author) {
    super(id, name, cost);
    this.author = author;
  }
  
  @Override
  public boolean matches(String search) {
    if (!super.matches(search)) {
      if (author.contains(search)) {
        return true;
      }
      return false;
    }
    return true;
  }
}
