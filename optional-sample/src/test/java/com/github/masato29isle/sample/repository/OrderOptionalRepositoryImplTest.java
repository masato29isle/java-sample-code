package com.github.masato29isle.sample.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 注文情報リポジトリ(Optional版)テストクラス
 */
class OrderOptionalRepositoryImplTest {

    /**
     * 注文情報リポジトリ(Optional)
     */
    private final OrderOptionalRepository repository = new OrderOptionalRepositoryImpl();

    private static final String NOT_FOUND_ORDER_ID = "0004";

    private static final String TARGET_ORDER_ID = "0001";

    @DisplayName("注文情報が存在しない")
    @Test
    void caseWithNoOrderTest() {
        // 空のOptionalが返却される
        assertFalse(repository.getOrder(NOT_FOUND_ORDER_ID).isPresent());
    }

    @DisplayName("注文情報が存在する")
    @Test
    void caseWithExistOrderTest() {
        // Optionalに値が含まれている
        assertTrue(repository.getOrder(TARGET_ORDER_ID).isPresent());
        // 指定した注文情報の金額と合致する
        assertEquals(100, repository.getOrder(TARGET_ORDER_ID).get().getPrice());
    }

}