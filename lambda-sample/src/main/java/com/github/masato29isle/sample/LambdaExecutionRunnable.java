package com.github.masato29isle.sample;

import com.github.masato29isle.sample.service.SampleService;
import com.github.masato29isle.sample.service.SampleServiceImpl;

/**
 * Runnable型Lambdaサンプル実行クラス
 */
public class LambdaExecutionRunnable implements LambdaExecution {
    @Override
    public void execute() {
        // sample 1 (SampleServiceの実装クラス作成 → インスタンス作成 → メソッド呼び出し)
        SampleService sampleService1 = new SampleServiceImpl();
        sampleService1.execute();

        // sample 2 (SampleServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // 匿名クラス
        // 実装クラスを作成するという手順を省略している
        SampleService sampleService2 = new SampleService() {
            @Override
            public void execute() {
                System.out.println("execute Sample Service(Anonymous)");
            }
        };
        sampleService2.execute();

        // sample 3 (SampleServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // lambda式
        // 実装クラスを作成するという手順を省略しつつ、[Interfaceの実装 + インスタンス作成]の手順を簡略化している
        SampleService sampleService3 = () -> {
            System.out.println("execute Sample Service(lambda)");
        };
        sampleService3.execute();

        // sample 4 (SampleServiceInterfaceの実装 + インスタンス作成 → メソッド呼び出し)
        // lambda式
        // 処理が1文の場合のみ処理ブロック({})の省略も可
        SampleService sampleService4 = () -> System.out.println("execute Sample Service(lambda2)");
        sampleService4.execute();

        // 引数の中でlambda関数定義することも可能
        execute(() -> System.out.println("execute Sample Service(lambda privateMethod)"));
    }

    /**
     * サンプルサービスを実行する
     * @param sampleService サンプルサービス定義
     */
    private void execute(SampleService sampleService) {
        System.out.println("::START::");
        sampleService.execute();
        System.out.println("::END::");
    }
}
