package sk.stuba.fei.uim.oop.assignment3.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService service;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse create(){
        return  new CartResponse(this.service.create());
    }
    @GetMapping("/{ID}")
    public CartResponse getById(@PathVariable("ID")int id){
        return new CartResponse(this.service.getById(id));
    }
    @DeleteMapping("/{ID}")
    public void delete(@PathVariable("ID")int id){
        this.service.deleteCart(id);
    }
    @PostMapping("/{ID}/add")
    public CartResponse add(@RequestBody ListProductRequest request,@PathVariable("ID")int id){
    return new CartResponse(this.service.addNewProduct(request,id));
    }
    @GetMapping("/{ID}/pay")
    public String pay(@PathVariable("ID")int id) throws Throwable {
        return new String(this.service.pay(id));
    }

}
