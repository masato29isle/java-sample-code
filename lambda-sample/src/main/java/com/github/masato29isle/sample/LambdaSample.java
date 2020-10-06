package com.github.masato29isle.sample;

import com.github.masato29isle.sample.constants.ExecutionCategory;

/**
 * lambda-sample実行クラス
 */
public class LambdaSample {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalStateException("実行時引数が存在しません");
        }
        // 実行時引数に指定した区分値に該当する実行カテゴリのLambdaサンプルを実行する
        execute(ExecutionCategory.getByValue(args[0]));
    }

    /**
     * 指定した実行カテゴリのLambdaサンプルを実行する
     *
     * @param executionCategory 実行カテゴリ
     */
    private static void execute(ExecutionCategory executionCategory) {
        System.out.println("Execution Category : " + executionCategory.name());
        executionCategory.execute();
    }
}
