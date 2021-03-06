package sk.stuba.fei.uim.oop.assignment3.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private Integer id;

    private String name;
    private String description;
    private Long amount;
    private String unit;
    private double price;
}
