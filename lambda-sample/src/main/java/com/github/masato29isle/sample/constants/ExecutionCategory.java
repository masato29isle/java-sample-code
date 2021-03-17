package com.github.masato29isle.sample.constants;

import com.github.masato29isle.sample.*;

import java.util.Arrays;

/**
 * Lambdaサンプル実行カテゴリ
 */
public enum ExecutionCategory {
    /**
     * 引数なし-戻り値なし
     */
    RUNNABLE("1", new LambdaExecutionRunnable()),
    /**
     * 引数あり-戻り値なし
     */
    CONSUMER("2", new LambdaExecutionConsumer()),
    /**
     * 引数なし-戻り値あり
     */
    SUPPLIER("3", new LambdaExecutionSupplier()),
    /**
     * 引数あり-戻り値あり
     */
    FUNCTION("4", new LambdaExecutionFunction());

    /**
     * 区分値
     */
    private final String value;

    /**
     * Lambda実行オブジェクト
     */
    private final LambdaExecution lambdaExecution;

    ExecutionCategory(String value, LambdaExecution lambdaExecution) {
        this.value = value;
        this.lambdaExecution = lambdaExecution;
    }

    public String getValue() {
        return value;
    }

    /**
     * 実行カテゴリに属するLambdaサンプルを実行する
     */
    public void execute() {
        lambdaExecution.execute();
    }

    /**
     * 区分値から実行カテゴリを取得する
     *
     * @param value 区分値
     * @return 実行カテゴリ
     */
    public static ExecutionCategory getByValue(String value) {
        return Arrays.stream(ExecutionCategory.values())
                .filter(category -> category.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("引数の値が不正です"));
    }

}
