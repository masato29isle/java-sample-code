package com.github.masato29isle.sample;

import com.github.masato29isle.sample.constants.ExecutionCategory;

/**
 * date-time-api-sample実行クラス
 */
public class DateTimeApiSample {

    public static void main(String[] args) {
        // Date-Time-Api を使用した場合のサンプルコードを実行する
        System.out.println("実行結果：" + ExecutionCategory.DATE_TIME_API.execute());
        // Date-Time-Api を使用しない場合のサンプルコードを実行する
        System.out.println("実行結果：" + ExecutionCategory.NON_DATE_TIME_API.execute());
    }
}
