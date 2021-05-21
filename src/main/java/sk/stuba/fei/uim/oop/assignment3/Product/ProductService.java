package sk.stuba.fei.uim.oop.assignment3.Product;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;
import sk.stuba.fei.uim.oop.assignment3.Product.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.Product.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }
    public Product create(ProductRequest request){
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setAmount(request.getAmount());
        newProduct.setDescription(request.getDescription());
        newProduct.setPrice(request.getPrice());
        newProduct.setUnit(request.getUnit());
        newProduct = this.repository.save(newProduct);
        return  newProduct;
    }
    public Product update(ProductRequest request,int id){
        Product productToUpdate = getById(id);
        if(request.getName() != null) {
            productToUpdate.setName(request.getName());
        }
        if(request.getAmount() != 0) {
            productToUpdate.setAmount(request.getAmount());
        }
        if(request.getDescription()!=null) {
            productToUpdate.setDescription(request.getDescription());
        }
        if(request.getPrice()!=0.0) {
            productToUpdate.setPrice(request.getPrice());
        }
        if(request.getUnit() != null) {
            productToUpdate.setUnit(request.getUnit());
        }
        productToUpdate = this.repository.save(productToUpdate);
        return productToUpdate;
    }

    @Override
    public Product getById(int id)  {
        return this.repository.findById(id).orElseThrow();
    }
    public void delete(int id){
       Product productToDelete = getById(id);
       this.repository.deleteById(id);
    }
    public AmountClass addAmount(ProductRequest request, int id){
        Product productToUpdate = getById(id);
        productToUpdate.setAmount(productToUpdate.getAmount() + request.getAmount());
        productToUpdate = this.repository.save(productToUpdate);
        return  new AmountClass(productToUpdate.getAmount());
    }
    public AmountClass getAmount(int id){
        return new AmountClass(this.repository.findById(id).orElseThrow().getAmount());
    }
}
