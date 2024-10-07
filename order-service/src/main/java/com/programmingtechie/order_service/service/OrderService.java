package com.programmingtechie.order_service.service;

import com.programmingtechie.order_service.dto.OrderLineItemsDto;
import com.programmingtechie.order_service.dto.OrderRequest;
import com.programmingtechie.order_service.model.Order;
import com.programmingtechie.order_service.model.OrderLineItems;
import com.programmingtechie.order_service.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService  {
    @Autowired
    private OrderRepo orderRepo;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(orderlineItemsDto ->
                     maptoDto(orderlineItemsDto)).toList();
        order.setOrderLineItems(orderLineItems);
        orderRepo.save(order);
    }

    private OrderLineItems maptoDto(OrderLineItemsDto orderlineItemsDto) {
        OrderLineItems orderLineItems = OrderLineItems.builder()
                .quantity(orderlineItemsDto.getQuantity())
                .price(orderlineItemsDto.getPrice())
                .skuCode(orderlineItemsDto.getSkuCode())
                .build();
        return orderLineItems;
    }
}
