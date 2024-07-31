package com.example.coffeeweb.Service;

import com.example.coffeeweb.Entity.Product;
import com.example.coffeeweb.Pojo.ProductPojo;

import java.util.List;

public interface ProductService {

    Integer

    saveProduct(ProductPojo productPojo);

    List<Product> findAll();

    Product findById(Integer id);

    void deleteById(Integer id);
}
