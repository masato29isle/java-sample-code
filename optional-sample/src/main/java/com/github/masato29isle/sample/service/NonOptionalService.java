package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.model.Order;
import com.github.masato29isle.sample.repository.OrderNonOptionalRepository;

/**
 * Non-Optional-実行サービス
 */
public class NonOptionalService implements SampleService {

    /**
     * 注文情報リポジトリ
     */
    private final OrderNonOptionalRepository orderNonOptionalRepository;

    public NonOptionalService(OrderNonOptionalRepository orderNonOptionalRepository) {
        this.orderNonOptionalRepository = orderNonOptionalRepository;
    }

    @Override
    public void execute(String orderId) {
        Order order = orderNonOptionalRepository.getOrder(orderId);
        if (order != null) {
            System.out.println("注文金額は" + order.getPrice() + "円です");
        } else {
            throw new IllegalArgumentException("指定された注文情報は存在しません");
        }
    }
}
