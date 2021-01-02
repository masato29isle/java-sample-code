package com.github.masato29isle.sample.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * 売上情報リポジトリ(Non-Date-Time-API版)
 */
public class SaleInfoRepository2 {

    /**
     * 指定した店舗の最終売上日時を取得する
     *
     * @param storeId 店舗ID
     * @return 最終売上日時
     */
    public Optional<Date> getFinalSaleTime(String storeId) {
        Calendar targetDateTime = Calendar.getInstance();
        targetDateTime.set(2020,Calendar.DECEMBER,12,12,45);

        return  Optional.ofNullable(targetDateTime.getTime());
    }
}
