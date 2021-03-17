package com.github.masato29isle.sample.service;

/**
 * sample-service-interface
 */
public interface SampleService {

    /**
     * Sample-Serviceを実行する(一週間以上売上が発生していないか判定する)
     *
     * @param storeId 店舗ID
     * @return {@code true} 最終売上日時が現在日時から一週間(7日)以上経過、もしくは最終売上日時が未設定
     */
    boolean checkNotSaleMoreThanOneWeek(String storeId);
}
