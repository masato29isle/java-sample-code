package com.github.masato29isle.sample.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * 売上情報
 */
public class SaleInfo {
    /**
     * 店舗ID
     */
    private final String storeId;
    /**
     * 最終売上日時
     */
    private final LocalDateTime finalSaleTime;

    public SaleInfo(String storeId, LocalDateTime finalSaleTime) {
        this.storeId = storeId;
        this.finalSaleTime = finalSaleTime;
    }

    /**
     * 指定された店舗IDと合致するか判定する
     *
     * @param storeId 店舗ID
     * @return 判定結果
     */
    public boolean matchStoreId(String storeId) {
        return Objects.equals(this.storeId, storeId);
    }

    /**
     * 最終売上日時を取得する
     *
     * @return 最終売上日時
     */
    public Optional<LocalDateTime> getFinalSaleTime() {
        return Optional.ofNullable(finalSaleTime);
    }
}
