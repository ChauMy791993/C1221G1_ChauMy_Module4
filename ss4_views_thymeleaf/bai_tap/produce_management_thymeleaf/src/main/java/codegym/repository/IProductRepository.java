package codegym.repository;

import codegym.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    void delete(Integer id);

    void update(int id, Product product);

    Product findById(int id);

    List<Product> findByName(String name);


}
