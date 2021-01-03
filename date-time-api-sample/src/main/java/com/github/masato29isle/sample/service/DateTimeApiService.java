package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.repository.SaleInfoRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Date-Time-Api-Sample実行サービス
 */
public class DateTimeApiService implements SampleService {

    /**
     * 売上情報リポジトリ(Date-Time-API版)
     */
    private final SaleInfoRepository saleInfoRepository;

    public DateTimeApiService(SaleInfoRepository saleInfoRepository) {
        this.saleInfoRepository = saleInfoRepository;
    }

    @Override
    public boolean checkNotSaleMoreThanOneWeek(String storeId) {
        LocalDateTime finalSaleTime = saleInfoRepository.getFinalSaleTime(storeId)
                .orElse(LocalDateTime.MIN);

        return finalSaleTime.isBefore(LocalDateTime.now()
                .minusWeeks(1)
                .truncatedTo(ChronoUnit.DAYS));
    }
}
