package com.github.masato29isle.sample.constants;

import com.github.masato29isle.sample.service.NonStreamApiService;
import com.github.masato29isle.sample.service.SampleService;
import com.github.masato29isle.sample.service.StreamApiService;

import java.util.List;

/**
 * StreamAPIサンプル実行カテゴリ
 */
public enum ExecutionCategory {
    /**
     * Stream-API-Service
     */
    STREAM_API(new StreamApiService()),
    /**
     * Non-Stream-API-Service
     */
    NON_STREAM_API(new NonStreamApiService());

    /**
     * sampleServiceオブジェクト
     */
    private final SampleService sampleService;

    private ExecutionCategory(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /**
     * 実行カテゴリに属するStreamAPIサンプルを実行する
     */
    public List<String> execute(List<String> targetList) {
        return sampleService.execute(targetList);
    }

}
