package sk.stuba.fei.uim.oop.assignment3.Cart;

public interface ICartService {
    Cart create();
    Cart getById(int id);
    void deleteCart(int id);
    Cart addNewProduct(ListProductRequest product, int id);
    String pay(int id) throws Throwable;
}
