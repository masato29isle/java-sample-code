package com.github.masato29isle.sample.model;

import java.util.Objects;

/**
 * 注文情報
 */
public class Order {

    /**
     * 注文ID
     */
    private final String orderId;

    /**
     * 注文金額
     */
    private final int price;

    /**
     * コンストラクタ
     *
     * @param orderId 注文ID
     * @param price   注文金額
     */
    public Order(String orderId, int price) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("注文IDは必須です");
        }
        this.orderId = orderId;
        this.price = price;
    }

    /**
     * 注文金額を取得する
     *
     * @return 注文金額
     */
    public int getPrice() {
        return price;
    }

    /**
     * 指定した注文IDが注文情報に存在するか判定する
     *
     * @param orderId 注文ID
     * @return 判定結果
     */
    public boolean isOrder(String orderId) {
        return Objects.equals(this.orderId, orderId);
    }

}
