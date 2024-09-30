package com.programmingtechie.product_service.controller;

import com.programmingtechie.product_service.Service.ProductService;
import com.programmingtechie.product_service.dto.ProductReq;
import com.programmingtechie.product_service.dto.ProductRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductReq productReq){
        productService.createProduct(productReq);
    }

    @GetMapping
    public List<ProductRespo> getAllProduct(){
        return productService.getAllProduct();
    }
}
