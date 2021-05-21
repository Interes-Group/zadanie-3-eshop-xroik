package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<ListProduct> shoppingList;
    private boolean payed;

    public Cart(){
        shoppingList = new ArrayList<>();
        payed = false;
    }

}
