package codegym.repository;

import codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    public static Map<Integer, Product> produceList = new HashMap<>();

    static {
        produceList.put(1, new Product(1, "iphone9", 20.000, "màu trắng", "apple"));
        produceList.put(2, new Product(2, "iphone10", 20.000, "màu trắng", "apple"));
        produceList.put(3, new Product(3, "iphone11", 20.000, "màu trắng", "apple"));
        produceList.put(4, new Product(4, "iphone12", 20.000, "màu trắng", "apple"));
        produceList.put(5, new Product(5, "iphone13", 20.000, "màu trắng", "apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(produceList.values());
    }

    @Override
    public void save(Product product) {

        produceList.put(product.getId(), product);
    }

    @Override
    public void delete(Integer id) {
        produceList.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        produceList.put(id, product);
    }

    @Override
    public Product findById(int id) {

        return produceList.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productFindList = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                productFindList.add(product);
            }
        }
        return productFindList;
    }
}
