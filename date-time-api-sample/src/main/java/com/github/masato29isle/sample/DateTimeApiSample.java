package com.github.masato29isle.sample;

import com.github.masato29isle.sample.constants.ExecutionCategory;

public class DateTimeApiSample {

    public static void main(String[] args) {

        System.out.println("実行結果：" + ExecutionCategory.DATE_TIME_API.execute());

        System.out.println("実行結果：" + ExecutionCategory.NON_DATE_TIME_API.execute());

    }
}
