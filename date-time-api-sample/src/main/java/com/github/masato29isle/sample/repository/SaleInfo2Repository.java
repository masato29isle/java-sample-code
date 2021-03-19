package com.github.masato29isle.sample.repository;

import com.github.masato29isle.sample.model.SaleInfo2;
import com.github.masato29isle.sample.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 売上情報リポジトリ(Non-Date-Time-API版)
 */
public class SaleInfo2Repository {

    /**
     * 既定売上情報リスト
     */
    private static final List<SaleInfo2> DEFAULT_SALE_INFO_LIST = List.of(
            new SaleInfo2("0001", DateUtil.createDate(2020, 12, 12, 10, 45))
            , new SaleInfo2("0002", DateUtil.createDate(2020, 12, 20, 10, 45))
            , new SaleInfo2("0003", null)
    );

    /**
     * 指定した店舗の最終売上日時を取得する
     *
     * @param storeId 店舗ID
     * @return 最終売上日時
     */
    public Optional<Date> getFinalSaleTime(String storeId) {
        return DEFAULT_SALE_INFO_LIST.stream()
                .filter(saleInfo -> saleInfo.matchStoreId(storeId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("指定された店舗情報は存在しません"))
                .getFinalSaleTime();
    }
}
