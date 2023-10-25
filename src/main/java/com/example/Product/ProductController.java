package com.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }
    @PostMapping("/addProducts")
    public String addProducts(@RequestBody List<Product> products)
    {
        return productService.addProducts(products);
    }

    @GetMapping("/get_product")
    public Product getProduct(@RequestParam("id") int id)
    {
        return productService.getProduct(id);
    }
    @GetMapping("get_Products")
    public List<Product> getProducts()
    {
        return productService.getProducts();
    }

    @GetMapping("/getproduct/{id}")
    public Product getproductById(@PathVariable int id)
    {
        return productService.getProductById(id);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id)
    {
        return productService.deleteProduct(id);
    }
}
