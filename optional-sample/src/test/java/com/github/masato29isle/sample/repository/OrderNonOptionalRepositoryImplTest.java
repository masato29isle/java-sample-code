package com.github.masato29isle.sample.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 注文情報リポジトリ(Non-Optional版)テストクラス
 */
class OrderNonOptionalRepositoryImplTest {

    /**
     * 注文情報リポジトリ(Non-Optional)
     */
    private final OrderNonOptionalRepository repository = new OrderNonOptionalRepositoryImpl();

    private static final String NOT_FOUND_ORDER_ID = "0004";

    private static final String TARGET_ORDER_ID = "0001";

    @DisplayName("注文情報が存在しない")
    @Test
    void caseWithNoOrderTest() {
        // 戻り値がNullである
        assertNull(repository.getOrder(NOT_FOUND_ORDER_ID));
    }

    @DisplayName("注文情報が存在する")
    @Test
    void caseWithExistOrderTest() {
        // 戻り値がNullではない
        assertNotNull(repository.getOrder(TARGET_ORDER_ID));
        // 指定した注文情報の金額と合致する
        assertEquals(100, repository.getOrder(TARGET_ORDER_ID).getPrice());
    }

}