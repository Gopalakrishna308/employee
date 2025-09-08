package com.employee.service;

import com.employee.entity.Product;
import com.employee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product)
    {
        productRepository.save(product);
    }
    public Product findById(int id)
    {
        return productRepository.findById(id).get();
    }
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }
    public  void deleteById(int id)
    {
        productRepository.deleteById(id);
    }

    public Optional<?> updateProduct(int id, Product product)
    {
      return productRepository.findById(id).map (
        ex ->{
                ex.setPrice(product.getPrice());
                ex.setQuantity(product.getQuantity());
                ex.setProductName(product.getProductName());
                return productRepository.save(ex);
    } );

    }




}
