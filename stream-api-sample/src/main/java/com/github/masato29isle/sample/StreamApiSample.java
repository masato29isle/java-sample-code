package com.github.masato29isle.sample;

import com.github.masato29isle.sample.constants.ExecutionCategory;

import java.util.Arrays;

/**
 * stream-api-sample実行クラス
 */
public class StreamApiSample {

    public static void main(String[] args) {
        // テストデータ作成
        var targetList = Arrays.asList("1test", "test2", "TEST3", "4test", "1test", null, "10test");
        // Stream-API
        System.out.println(ExecutionCategory.STREAM_API.execute(targetList));
        // Non-Stream-API
        System.out.println(ExecutionCategory.NON_STREAM_API.execute(targetList));
    }

}
