package sk.stuba.fei.uim.oop.assignment3.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private IProductService service;
    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(product -> new ProductResponse(product)).collect(Collectors.toList());
     }
     @PostMapping()
    public ProductResponse addProduct(@RequestBody ProductRequest request){
    return new ProductResponse(this.service.create(request));
     }
     @GetMapping("/{ID}")
    public ProductResponse getById(@PathVariable("ID") int id) {
        return new ProductResponse(this.service.getById(id));
     }
     @PutMapping("/{ID}")
    public ProductResponse update(@RequestBody ProductRequest request, @PathVariable("ID") int id){
        return new ProductResponse(this.service.update(request,id));
     }
     @DeleteMapping("/{ID}")
    public void delete(@PathVariable("ID")int id){
        this.service.delete(id);
     }
 }
