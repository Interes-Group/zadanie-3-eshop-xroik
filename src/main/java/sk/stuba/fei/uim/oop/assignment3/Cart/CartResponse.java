package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter

public class CartResponse {
    private int id;
    private List<ListProduct> shoppingList;
    private boolean payed;
    public CartResponse(Cart c){
        this.id = c.getId();
        this.shoppingList = c.getShoppingList();
        this.payed = c.isPayed();
    }
}
