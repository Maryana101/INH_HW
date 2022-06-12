package ru.netology.domain;

public class Manager {
  private Repository repo = new Repository();
  
  public Manager(Repository repo) {
    this.repo = repo;
  }
  
  
  public void add(Product newProduct) {
    repo.save(newProduct);
  }
  
  public void removeProduct(int id) {
    try {
      repo.removeById(id);
    } catch (ArrayIndexOutOfBoundsException e) {
      //nothing
    }
  }
  public void setProducts(Product[] products){
    repo.setProducts(products);
  }
  public Product[] getAllProducts() {
    return repo.getProducts();
  }
  
  public Product[] matches (String search){
    Product[] result=new Product[0];
    for (Product product : repo.getProducts()) {
      if (product.matches(search)){
        Product[] tmp=new Product[result.length+1];
        System.arraycopy(result,0,tmp,0,result.length);
        tmp[tmp.length-1]=product;
        result=tmp;
      }
    }
    return result;
  }
}
