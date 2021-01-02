package com.github.masato29isle.sample.repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 売上情報リポジトリ(Date-Time-API版)
 */
public class SaleInfoRepository {

    /**
     * 指定した店舗の最終売上日時を取得する
     *
     * @param storeId 店舗ID
     * @return 最終売上日時
     */
    public Optional<LocalDateTime> getFinalSaleTime(String storeId) {
        return Optional.ofNullable(LocalDateTime.of(2020,12,12,10,45));
    };
}
