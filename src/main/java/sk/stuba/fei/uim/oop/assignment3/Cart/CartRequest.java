package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {
    private int id;
    private List<ListProduct> shoppingList;
    private boolean payed;
}
