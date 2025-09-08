package com.employee.controller;

import com.employee.entity.Product;
import com.employee.repository.ProductRepository;
import com.employee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
   public String saveProduct(@RequestBody Product product)
   {
       productService.saveProduct(product);
       return "product saved successfully";
   }

   @GetMapping("/view/{id}")
   public ResponseEntity<?> findById(@PathVariable int id)
   {

       return  ResponseEntity.ok(productService.findById(id));
   }
   @GetMapping("/viewAll")
    public ResponseEntity<List> findAll()
   {
       return  ResponseEntity.ok(productService.findAll());
   }
   @DeleteMapping ("/delete/{id}")
    public String deleteById(@PathVariable int id)
   {
      productService.deleteById(id);
             return "product deleted successfully";
   }
   @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id,@RequestBody Product product)
   {
      return   productService.updateProduct(id, product).map(ResponseEntity::ok).
              orElse(ResponseEntity.notFound().build());
   }
}







