package sk.stuba.fei.uim.oop.assignment3.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class AmountClass {
    Integer amount;

    public AmountClass(Integer amount) {
        this.amount = amount;
    }
}
