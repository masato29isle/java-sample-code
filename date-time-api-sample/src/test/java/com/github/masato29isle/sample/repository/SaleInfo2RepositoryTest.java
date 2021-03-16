package com.github.masato29isle.sample.repository;

import com.github.masato29isle.sample.util.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * 売上情報リポジトリ(Non-Date-Time-API版)テストクラス
 */
import static org.junit.jupiter.api.Assertions.*;

class SaleInfo2RepositoryTest {

    /**
     * テスト対象リポジトリ
     */
    private final SaleInfo2Repository repository = new SaleInfo2Repository();

    @DisplayName("指定された店舗IDが存在しない")
    @Test
    void caseWithNotExistTargetStoreId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> repository.getFinalSaleTime("0004"));
        assertEquals("指定された店舗情報は存在しません", exception.getMessage());
    }

    @DisplayName("指定された店舗ID[0001]の売上情報が存在する")
    @Test
    void caseWithExistTargetStoreId0001AndExistSalesInformation() {
        assertEquals(Optional.of(DateUtil.createDate(2020, 12, 12, 10, 45)),
                repository.getFinalSaleTime("0001"));
    }

    @DisplayName("指定された店舗ID[0002]の売上情報が存在する")
    @Test
    void caseWithExistTargetStoreId0002AndExistSalesInformation() {
        assertEquals(Optional.of(DateUtil.createDate(2020, 12, 20, 10, 45)),
                repository.getFinalSaleTime("0002"));
    }

    @DisplayName("指定された店舗ID[0003]の売上情報が存在する")
    @Test
    void caseWithExistTargetStoreId0003AndExistSalesInformation() {
        assertEquals(Optional.empty(), repository.getFinalSaleTime("0003"));
    }

}