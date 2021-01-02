package com.github.masato29isle.sample.constants;

import com.github.masato29isle.sample.repository.SaleInfoRepository;
import com.github.masato29isle.sample.repository.SaleInfoRepository2;
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
    NON_DATE_TIME_API(new NonDateTimeApiService(new SaleInfoRepository2()));

    private final SampleService sampleService;

    private ExecutionCategory(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public boolean execute() {
        return sampleService.checkNotSaleMoreThanOneWeek("00001");
    }

}
