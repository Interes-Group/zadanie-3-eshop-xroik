package sk.stuba.fei.uim.oop.assignment3.Cart;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ListProduct {
    @Id
    private int productId;
    private Integer amount;
    public ListProduct(ListProductRequest productToAdd) {
        this.productId = productToAdd.getProductId();
        this.amount = productToAdd.getAmount();
    }

    public ListProduct() {

    }
}
