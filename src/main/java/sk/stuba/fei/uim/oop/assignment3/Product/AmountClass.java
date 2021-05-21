package sk.stuba.fei.uim.oop.assignment3.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class AmountClass {
    Long amount;

    public AmountClass(Long amount) {
        this.amount = amount;
    }
}
