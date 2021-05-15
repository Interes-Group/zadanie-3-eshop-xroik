package sk.stuba.fei.uim.oop.assignment3.Product;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.Product.Product;

@Getter
public class ProductResponse {
    private Integer id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;
    public ProductResponse(Product p){
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.price = p.getPrice();
    }
}
