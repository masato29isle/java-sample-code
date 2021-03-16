package com.github.masato29isle.sample.service;

import com.github.masato29isle.sample.repository.SaleInfoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

/**
 * Date-Time-Api-Sample実行サービステストクラス
 */
@ExtendWith(MockitoExtension.class)
class DateTimeApiServiceTest {

    /**
     * テスト対象サービス
     */
    private SampleService sampleService;

    /**
     * 売上情報リポジトリ(Date-Time-API版)
     */
    @Mock
    private SaleInfoRepository saleInfoRepository;

    /**
     * テスト実行日付
     */
    private final Clock clock = Clock.fixed(Instant.parse("2020-12-21T10:20:30Z"), ZoneId.systemDefault());

    /**
     * テスト対象店舗ID
     */
    private final String TARGET_STORE_ID = "0001";

    @DisplayName("最終売上発生日時が１週間以上前である")
    @Test
    void caseWithExistSalesInformationMoreThanOneWeekAgo() {
        doReturn(Optional.of(LocalDateTime.of(2020, 12, 13, 10, 45)))
                .when(saleInfoRepository).getFinalSaleTime(TARGET_STORE_ID);
        sampleService = new DateTimeApiService(saleInfoRepository, clock);
        assertTrue(sampleService.checkNotSaleMoreThanOneWeek(TARGET_STORE_ID));
    }

    @DisplayName("最終売上発生日時が１週間以内である")
    @Test
    void caseWithExistSalesInformationWithinOneWeek() {
        doReturn(Optional.of(LocalDateTime.of(2020, 12, 14, 10, 45)))
                .when(saleInfoRepository).getFinalSaleTime(TARGET_STORE_ID);
        sampleService = new DateTimeApiService(saleInfoRepository, clock);
        assertFalse(sampleService.checkNotSaleMoreThanOneWeek(TARGET_STORE_ID));
    }

    @DisplayName("これまでに売上が一度も発生していない")
    @Test
    void caseWithNotExistSalesInformation() {
        doReturn(Optional.empty()).when(saleInfoRepository).getFinalSaleTime(TARGET_STORE_ID);
        sampleService = new DateTimeApiService(saleInfoRepository, clock);
        assertTrue(sampleService.checkNotSaleMoreThanOneWeek(TARGET_STORE_ID));
    }

}