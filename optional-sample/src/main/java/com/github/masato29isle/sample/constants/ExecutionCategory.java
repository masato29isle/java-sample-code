package com.github.masato29isle.sample.constants;

import com.github.masato29isle.sample.repository.OrderNonOptionalRepositoryImpl;
import com.github.masato29isle.sample.repository.OrderOptionalRepositoryImpl;
import com.github.masato29isle.sample.service.NonOptionalService;
import com.github.masato29isle.sample.service.OptionalService;
import com.github.masato29isle.sample.service.SampleService;

/**
 * Optionalサンプル実行カテゴリ
 */
public enum ExecutionCategory {
    /**
     * Optional-Service
     */
    OPTIONAL(new OptionalService(new OrderOptionalRepositoryImpl())),
    /**
     * Non-Optional-Service
     */
    NON_OPTIONAL(new NonOptionalService(new OrderNonOptionalRepositoryImpl()));

    /**
     * Optional実行オブジェクト
     */
    private final SampleService sampleService;

    ExecutionCategory(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /**
     * 実行カテゴリに属するOptionalサンプルを実行する
     */
    public void execute(String orderId) {
        sampleService.execute(orderId);
    }

}
