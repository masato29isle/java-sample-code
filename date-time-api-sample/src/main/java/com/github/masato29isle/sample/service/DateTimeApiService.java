package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.repository.SaleInfoRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeApiService implements SampleService {

    private SaleInfoRepository saleInfoRepository;

    public DateTimeApiService(SaleInfoRepository saleInfoRepository) {
        this.saleInfoRepository = saleInfoRepository;
    }

    @Override
    public boolean checkNotSaleMoreThanOneWeek(String storeId) {
        LocalDateTime finalSalesDateTime = saleInfoRepository.getFinalSaleTime(storeId)
                .orElseThrow(() -> new IllegalArgumentException("指定された店舗情報は存在しません"));

        return finalSalesDateTime.isBefore(LocalDateTime.now()
                .minusWeeks(1)
                .truncatedTo(ChronoUnit.DAYS));
    }
}
