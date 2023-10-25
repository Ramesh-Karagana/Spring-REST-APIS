package com.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public  String addProduct(Product product)
    {
        productRepository.save(product);
        return "added successfully";
    }
    public  String addProducts(List<Product> products)
    {
        productRepository.saveAll(products);
        return "added bulk products";
    }


    public Product getProduct(int id)
    {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "delete successfully";
    }
}
