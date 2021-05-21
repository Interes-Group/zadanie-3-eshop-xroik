package sk.stuba.fei.uim.oop.assignment3.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product create(ProductRequest request);
    Product getById(int id);
    Product update(ProductRequest request, int id);
    void delete(int id);
    AmountClass getAmount(int id);
    AmountClass addAmount(ProductRequest request, int id);
}
