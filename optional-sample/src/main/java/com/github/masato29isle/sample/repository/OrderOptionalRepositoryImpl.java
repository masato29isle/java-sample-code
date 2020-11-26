package com.github.masato29isle.sample.repository;

import com.github.masato29isle.sample.model.Order;

import java.util.List;
import java.util.Optional;

public class OrderOptionalRepositoryImpl implements OrderOptionalRepository {

    private static final List<Order> DEFAULT_ORDER_LIST = List.of(
            new Order("0001", 100)
            , new Order("0002", 200)
            , new Order("0003", 150)
    );

    @Override
    public Optional<Order> getOrder(String orderId) {
        return DEFAULT_ORDER_LIST.stream()
                .filter(order -> order.isOrder(orderId))
                .findFirst();
    }
}
