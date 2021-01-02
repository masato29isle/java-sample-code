package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.repository.SaleInfoRepository;
import com.github.masato29isle.sample.repository.SaleInfoRepository2;

import java.util.Calendar;
import java.util.Date;

public class NonDateTimeApiService implements SampleService {

    private final SaleInfoRepository2 saleInfoRepository;

    public NonDateTimeApiService(SaleInfoRepository2 saleInfoRepository) {
        this.saleInfoRepository = saleInfoRepository;
    }

    @Override
    public boolean checkNotSaleMoreThanOneWeek(String storeId) {
        Date finalSalesDateTime = saleInfoRepository.getFinalSaleTime(storeId)
                .orElseThrow(() -> new IllegalArgumentException("指定された店舗情報は存在しません"));

        Calendar currentDateTime = Calendar.getInstance();
        currentDateTime.set(Calendar.HOUR_OF_DAY, 0);
        currentDateTime.clear(Calendar.MINUTE);
        currentDateTime.clear(Calendar.SECOND);
        currentDateTime.clear(Calendar.MILLISECOND);

        long diffMilliTime = currentDateTime.getTimeInMillis() - finalSalesDateTime.getTime();
        long diffDay = diffMilliTime / (1000 * 60 * 60 * 24);

        if ( diffDay >= 7 ) {
            return true;
        } else {
            return false;
        }
    }
}
