package com.github.masato29isle.sample;

import com.github.masato29isle.sample.constants.ExecutionCategory;

/**
 * optional-sample実行クラス
 */
public class OptionalSample {

    /**
     * 処理対象注文ID
     */
    private static final String TARGET_ORDER_ID = "0001";

    public static void main(String[] args) {
        // Optional を使用した場合のサンプルコードを実行する
        ExecutionCategory.NON_OPTIONAL.execute(TARGET_ORDER_ID);
        // Optional を使用しない場合のサンプルコードを実行する
        ExecutionCategory.OPTIONAL.execute(TARGET_ORDER_ID);
    }
}
