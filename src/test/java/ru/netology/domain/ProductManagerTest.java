package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
  Product book1 = new Book(1, "Кот в шляпе", 62, "Доктор Сьюз");
  Product book2 = new Book(2, "Кот в сапогах", 40, "Шарль Перро");
  Product telephone1 = new Smartphone(3, "Nokia", 120, "Финляндия");
  Product telephone2 = new Smartphone(4, "Sony", 140, "Япония");
  Product book3 = new Book(5, "Уход за домашними кошками", 35, "Катерина Кошкина");
  
  Repository repo = new Repository();
  Manager manager = new Manager(repo);
  
  @Test
  public void shouldAddNewProductInEmptyRepo() {
    manager.add(book1);
    
    Product[] actual = manager.getAllProducts();
    Product[] expected = {book1};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldAddNewProductInNotEmptyRepo() {
    
    Product[] products = {book1, book2};
    manager.setProducts(products);
    manager.add(book3);
    
    Product[] actual = manager.getAllProducts();
    Product[] expected = {book1, book2, book3};
    
    assertArrayEquals(expected, actual);
    
  }
  
  @Test
  public void shouldRemoveProductByIdThenExists() {
    Product[] products = {book1, book2, telephone1};
    manager.setProducts(products);
    manager.removeProduct(3);
    
    Product[] actual = manager.getAllProducts();
    Product[] expected = {book1, book2};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldNotRemoveProductIdThenProductNotExists() {
    Product[] products = {book1, book2, telephone1};
    manager.setProducts(products);
    manager.removeProduct(4);
    
    Product[] actual = manager.getAllProducts();
    Product[] expected = {book1, book2, telephone1};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldSearchBooksByName() {
    Product[] products = {book1, book2, book3};
    manager.setProducts(products);
    
    Product[] actual = manager.matches("Кот");
    Product[] expected = {book1, book2};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldNotSearhProductsByName() {
    Product[] products = {book1, book2, book3};
    manager.setProducts(products);
    
    Product[] actual = manager.matches("кот");
    Product[] expected = {};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldSearhSmartphonesByName() {
    Product[] products = {telephone1, telephone2};
    manager.setProducts(products);
    
    Product[] actual = manager.matches("Sony");
    Product[] expected = {telephone2};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldSearchBooksByAuthor() {
    Product[] products = {book1, book3};
    manager.setProducts(products);
    
    Product[] actual = manager.matches("Сьюз");
    Product[] expected = {book1};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void shouldSearchSmartphonesByManufacturer() {
    Product[] products = {telephone1, telephone2};
    manager.setProducts(products);
    
    Product[] actual = manager.matches("Япония");
    Product[] expected = {telephone2};
    
    assertArrayEquals(expected, actual);
  }
  
  
}
