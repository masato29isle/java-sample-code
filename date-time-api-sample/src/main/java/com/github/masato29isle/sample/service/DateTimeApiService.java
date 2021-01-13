package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.repository.SaleInfoRepository;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Date-Time-Api-Sample実行サービス
 */
public class DateTimeApiService implements SampleService {

    /**
     * 売上情報リポジトリ(Date-Time-API版)
     */
    private final SaleInfoRepository saleInfoRepository;

    /**
     * Clock情報
     */
    private final Clock clock;

    public DateTimeApiService(SaleInfoRepository saleInfoRepository) {
        this(saleInfoRepository, Clock.systemDefaultZone());
    }

    public DateTimeApiService(SaleInfoRepository saleInfoRepository, Clock clock) {
        this.saleInfoRepository = saleInfoRepository;
        this.clock = clock;
    }

    @Override
    public boolean checkNotSaleMoreThanOneWeek(String storeId) {
        LocalDateTime finalSaleTime = saleInfoRepository.getFinalSaleTime(storeId)
                .orElse(LocalDateTime.MIN);

        return finalSaleTime.isBefore(LocalDateTime.now(clock)
                .minusWeeks(1)
                .truncatedTo(ChronoUnit.DAYS));
    }
}
