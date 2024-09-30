package com.programmingtechie.product_service.Service;

import com.programmingtechie.product_service.dto.ProductReq;
import com.programmingtechie.product_service.dto.ProductRespo;
import com.programmingtechie.product_service.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(ProductReq productReq);

    List<ProductRespo> getAllProduct();
}
