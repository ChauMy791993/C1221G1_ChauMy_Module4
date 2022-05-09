package codegym.repository;

import codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    void delete(Product product);

    void update(Product product);

    Product findById(int id);

    List<Product> findByName(String name);


}
