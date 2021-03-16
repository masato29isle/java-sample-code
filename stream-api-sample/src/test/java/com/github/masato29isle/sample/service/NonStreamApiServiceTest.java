package com.github.masato29isle.sample.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Non-Stream-API-実行サービステストクラス
 */
class NonStreamApiServiceTest {

    /**
     * Non-Stream-API-実行サービス
     */
    private final SampleService sampleService = new NonStreamApiService();

    @DisplayName("リスト要素にnullが含まれている")
    @Test
    void caseWithContainsNullElementTest() {
        // テストデータ
        List<String> targetList = Arrays.asList("1test", "2test", null, "3test");
        // リスト要素にnullが含まれていない
        assertEquals(List.of("1test", "2test", "3test"), sampleService.execute(targetList));
    }

    @DisplayName("リスト要素にsuffixが'test'ではない文字列が含まれている")
    @Test
    void caseWithContainsNotSuffix_test_CharElementTest() {
        // テストデータ
        List<String> targetList = List.of("1test", "test2", "3test", "4test");
        // リスト要素にsuffixが'test'ではない文字列が含まれていない
        assertEquals(List.of("1test", "3test", "4test"), sampleService.execute(targetList));
    }

    @DisplayName("リスト要素に重複した文字列(同じ文字列)が含まれている")
    @Test
    void caseWithContainsDistinctElementTest() {
        // テストデータ
        List<String> targetList = List.of("1test", "2test", "2test", "3test");
        // リスト要素に重複した文字列が含まれていない
        assertEquals(List.of("1test", "2test", "3test"), sampleService.execute(targetList));
    }

    @DisplayName("複数のフィルタリング条件に合致するデータでの整合性確認")
    @Test
    void caseWithMultiConditionTest() {
        // テストデータ
        List<String> targetList = Arrays.asList("1test", "2test", "test3", null, "2test", "4test");
        // 返却されるリスト要素が以下条件を満たしている
        // 1. リスト要素にnullが含まれていない
        // 2. リスト要素にsuffixが'test'ではない文字列が含まれていない
        // 3. リスト要素に重複した文字列が含まれていない
        assertEquals(List.of("1test", "2test", "4test"), sampleService.execute(targetList));
    }

}