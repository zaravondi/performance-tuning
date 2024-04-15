package com.ing.performancetuning.controller;

import com.ing.performancetuning.contracts.TotalCostResponse;
import com.ing.performancetuning.model.Product;
import com.ing.performancetuning.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    private static final List<Product> products = new ArrayList<>();
    private BigDecimal total=BigDecimal.ZERO;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/total/costs")
    public TotalCostResponse totalCosts() {

        return productService.getTotalCosts();
    }

    @PostMapping("/addProduct")
    public BigDecimal addProduct() {
        Product product =new Product();
        product.setName("product");
        product.setPrice(BigDecimal.ONE);
        product.setQuantity(1);
        products.add(product);


        for(Product p:products){
            total= total.add(p.getPrice());
        }

     return total;
    }

    @PostMapping("/addProduct1")
    public BigDecimal addProduct1() {
        Product product =new Product();
        product.setName("product");
        BigDecimal min = BigDecimal.ONE;
        BigDecimal max = new BigDecimal(100);
        Random random = new Random();

        double randomValue = BigDecimal.ONE.doubleValue() + (max.doubleValue() - min.doubleValue()) * random.nextDouble();
        BigDecimal randomBigDecimal = BigDecimal.valueOf(randomValue);

        product.setPrice(randomBigDecimal);
        product.setQuantity(1);

        productService.saveProduct(product);

        return productService.findAllProduct().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    }


}