package sk.stuba.fei.uim.oop.assignment3.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;
import sk.stuba.fei.uim.oop.assignment3.Product.ProductRepository;

@Service
public class CartService implements  ICartService {

    @Autowired
    private CartRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Cart create() {
        Cart newCart = new Cart();
        newCart = this.repository.save(newCart);
        return newCart;
    }

    @Override
    public Cart getById(int id) {
        return this.repository.findById(id).orElseThrow();
    }



    @Override
    public void deleteCart(int id) {
        Cart cart = getById(id);
        this.repository.deleteById(id);
    }

    @Override
    public Cart addNewProduct(ListProduct productToAdd,int id) {
        Cart cart = this.repository.findById(id).orElseThrow();
        if(cart.isPayed()){
            return null;
            // throw isPayesException
        }
        else{
            Product productOnStorage = productRepository.findById(productToAdd.getProductId()).get();
            if(productOnStorage.getAmount() < productToAdd.getAmount()){
                //throw notEnoughAmountException
                return null;
            }
            else{
                cart.getShoppingList().add(productToAdd);
                productOnStorage.setAmount(productOnStorage.getAmount() - productToAdd.getAmount());
                this.repository.save(cart);
                this.productRepository.save(productOnStorage);
                return cart;
            }
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    void isPayedException() {

    }

    @Override
    public  String pay(int id){
        Cart cart = repository.findById(id).orElseThrow();
        if(cart.isPayed()){
           isPayedException();
           return null;
        }
        else{
            double sum;
            cart.setPayed(true);
            sum = cart.getShoppingList().stream().mapToDouble(product -> product.getAmount() * productRepository.findById(product.getProductId()).orElseThrow().getPrice()).sum();
            return ""+sum;
        }
    }
}
