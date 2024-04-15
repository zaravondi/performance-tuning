package com.ing.performancetuning.service;

import com.ing.performancetuning.contracts.TotalCostResponse;
import com.ing.performancetuning.model.Product;
import com.ing.performancetuning.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public TotalCostResponse getTotalCosts() {
        TotalCostResponse response = new TotalCostResponse();
        try {
            var products = productRepository.findAll();

            var costs = products.stream()
                    .collect(Collectors.toMap(
                            Product::getName,
                            p -> p.getPrice().multiply(new BigDecimal(p.getQuantity()))));

            response.setTotalCosts(costs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public void saveProduct(Product product){
        productRepository.saveAndFlush(product);
        System.out.println(productRepository.findAll().stream().count());

    }
    public List<Product> findAllProduct(){
        return   productRepository.findAll();

    }

}