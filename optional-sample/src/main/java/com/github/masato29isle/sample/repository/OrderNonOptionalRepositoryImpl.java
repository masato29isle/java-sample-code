package com.github.masato29isle.sample.repository;

import com.github.masato29isle.sample.model.Order;

import java.util.List;

public class OrderNonOptionalRepositoryImpl implements OrderNonOptionalRepository {

    private static final List<Order> DEFAULT_ORDER_LIST = List.of(
            new Order("0001", 100)
            , new Order("0002", 200)
            , new Order("0003", 150)
    );

    @Override
    public Order getOrder(String orderId) {
        for (Order order : DEFAULT_ORDER_LIST) {
            if(order.isOrder(orderId)) {
                return order;
            }
        }
        return null;
    }
}
