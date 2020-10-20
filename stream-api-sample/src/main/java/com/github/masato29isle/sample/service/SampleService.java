package com.github.masato29isle.sample.service;

import java.util.List;

/**
 * sample-service-interface
 */
public interface SampleService {

    /**
     * 条件に合致したリストデータを返す
     *
     * @param targetList 処理対象リストデータ
     * @return 条件に合致したリストデータ
     */
    List<String> execute(List<String> targetList);
}
