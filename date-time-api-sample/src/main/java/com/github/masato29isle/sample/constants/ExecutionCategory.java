package com.github.masato29isle.sample.constants;

import com.github.masato29isle.sample.repository.SaleInfoRepository;
import com.github.masato29isle.sample.repository.SaleInfo2Repository;
import com.github.masato29isle.sample.service.DateTimeApiService;
import com.github.masato29isle.sample.service.NonDateTimeApiService;
import com.github.masato29isle.sample.service.SampleService;

/**
 * DateTimeAPIサンプル実行カテゴリ
 */
public enum ExecutionCategory {
    /**
     * Date-Time-Api
     */
    DATE_TIME_API(new DateTimeApiService(new SaleInfoRepository())),
    /**
     * Non-Date-Time-Api
     */
    NON_DATE_TIME_API(new NonDateTimeApiService(new SaleInfo2Repository()));

    /**
     * Sample-Service
     */
    private final SampleService sampleService;

    private ExecutionCategory(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /**
     * Sample-Serviceを実行する
     *
     * @param storeId 店舗ID
     * @return Sample-Service実行結果
     */
    public boolean execute(String storeId) {
        return sampleService.checkNotSaleMoreThanOneWeek(storeId);
    }

}
