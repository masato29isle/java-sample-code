package com.github.masato29isle.sample.repository;

import com.github.masato29isle.sample.model.Order;

import java.util.Optional;

/**
 * 注文情報リポジトリ
 */
public interface OrderNonOptionalRepository {

    /**
     * 注文情報を取得する
     *
     * @param orderId 注文ID
     * @return 注文情報
     */
    Order getOrder(String orderId);

}
