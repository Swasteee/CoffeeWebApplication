package com.example.coffeeweb.Service.impl;

import com.example.coffeeweb.Entity.Product;
import com.example.coffeeweb.Pojo.ProductPojo;
import com.example.coffeeweb.Repository.ProductRepository;
import com.example.coffeeweb.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Integer saveProduct(ProductPojo productPojo) {
        Product product = new Product();
        product.setProductName(productPojo.getProductName());
        product.setProductPrice(productPojo.getProductPrice());
        productRepository.save(product);
        return product.getProduct_id();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);

    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);

    }
}
