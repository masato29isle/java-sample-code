package com.github.masato29isle.sample.service;

/**
 * sample-service-interface
 */
public interface SampleService {

    /**
     * Sample-Serviceを実行する(一週間以上売上が発生していないか判定する)
     *
     * @param storeId 店舗ID
     * @return 売上有無判定結果
     */
    boolean checkNotSaleMoreThanOneWeek(String storeId);
}
