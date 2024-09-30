package com.programmingtechie.product_service.Service;

import com.programmingtechie.product_service.dto.ProductReq;
import com.programmingtechie.product_service.dto.ProductRespo;
import com.programmingtechie.product_service.model.Product;
import com.programmingtechie.product_service.repository.ProductRepo;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public void createProduct(ProductReq productReq) {
        Product product = Product.builder()
                .name(productReq.getName())
                .description(productReq.getDescription())
                .price(productReq.getPrice())
                .build();
        productRepo.save(product);
        log.info("product with id {} is saved", product.getId());
    }

    @Override
    public List<ProductRespo> getAllProduct() {
        List<Product> product = productRepo.findAll();
        return product.stream().map(product1 ->
                ProductRespo.builder()
                        .id(product1.getId())
                        .name(product1.getName())
                        .price(product1.getPrice())
                        .description(product1.getDescription())
                        .build()
                ).toList();
    }
}
