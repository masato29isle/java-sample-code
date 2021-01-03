package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.repository.SaleInfo2Repository;
import com.github.masato29isle.sample.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Non-Date-Time-Api-Sample実行サービス
 */
public class NonDateTimeApiService implements SampleService {

    /**
     * 売上情報リポジトリ(Non-Date-Time-API版)
     */
    private final SaleInfo2Repository saleInfoRepository;

    public NonDateTimeApiService(SaleInfo2Repository saleInfoRepository) {
        this.saleInfoRepository = saleInfoRepository;
    }

    @Override
    public boolean checkNotSaleMoreThanOneWeek(String storeId) {
        Date finalSaleTime = saleInfoRepository.getFinalSaleTime(storeId)
                .orElse(DateUtil.minDate());

        Calendar currentDateTime = Calendar.getInstance();
        currentDateTime.set(Calendar.HOUR_OF_DAY, 0);
        currentDateTime.clear(Calendar.MINUTE);
        currentDateTime.clear(Calendar.SECOND);
        currentDateTime.clear(Calendar.MILLISECOND);

        long diffMilliTime = currentDateTime.getTimeInMillis() - finalSaleTime.getTime();
        long diffDay = diffMilliTime / (1000 * 60 * 60 * 24);

        if (diffDay >= 7) {
            return true;
        } else {
            return false;
        }
    }
}
