package com.github.masato29isle.sample.repository;

import com.github.masato29isle.sample.model.SaleInfo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * 売上情報リポジトリ(Date-Time-API版)
 */
public class SaleInfoRepository {

    /**
     * 既定売上情報リスト
     */
    private static final List<SaleInfo> DEFAULT_SALE_INFO_LIST = List.of(
            new SaleInfo("0001", LocalDateTime.of(2020, 12, 12, 10, 45))
            , new SaleInfo("0002", LocalDateTime.of(2020, 12, 20, 10, 45))
            , new SaleInfo("0003", null)
    );

    /**
     * 指定した店舗の最終売上日時を取得する
     *
     * @param storeId 店舗ID
     * @return 最終売上日時
     */
    public Optional<LocalDateTime> getFinalSaleTime(String storeId) {
        return DEFAULT_SALE_INFO_LIST.stream()
                .filter(saleInfo -> saleInfo.matchStoreId(storeId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("指定された店舗情報は存在しません"))
                .getFinalSaleTime();
    }
}
