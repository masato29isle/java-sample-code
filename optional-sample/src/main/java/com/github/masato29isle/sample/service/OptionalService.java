package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.model.Order;
import com.github.masato29isle.sample.repository.OrderOptionalRepository;

import java.util.Objects;

/**
 * Optional-実行サービス
 */
public class OptionalService implements SampleService {

    /**
     * 注文情報リポジトリ
     */
    private final OrderOptionalRepository orderOptionalRepository;

    public OptionalService(OrderOptionalRepository orderOptionalRepository) {
        this.orderOptionalRepository = Objects.requireNonNull(orderOptionalRepository);
    }

    @Override
    public void execute(String orderId) {
        Order order = orderOptionalRepository.getOrder(orderId)
                .orElseThrow(() -> new IllegalArgumentException("指定された注文情報は存在しません"));
        System.out.println("注文金額は" + order.getPrice() + "円です");
    }
}
