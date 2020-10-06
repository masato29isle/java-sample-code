package com.github.masato29isle.sample;

import com.github.masato29isle.sample.service.SampleArgsService;
import com.github.masato29isle.sample.service.SampleArgsServiceImpl;

/**
 * Consumer型Lambdaサンプル実行クラス
 */
public class LambdaExecutionConsumer implements LambdaExecution {
    @Override
    public void execute() {
        // sample 1 (SampleArgsServiceの実装クラス作成 → インスタンス作成 → メソッド呼び出し)
        SampleArgsService sampleService1 = new SampleArgsServiceImpl();
        outputConsole(sampleService1);

        // sample 2 (SampleArgsServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // 匿名クラス
        SampleArgsService sampleService2 = new SampleArgsService() {
            @Override
            public void accept(String s) {
                System.out.println(s + "(Anonymous)");
            }
        };
        outputConsole(sampleService2);

        // sample 3 (SampleArgsServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // lambda式
        SampleArgsService sampleService3 = (s) -> {
            System.out.println(s + "(lambda)");
        };
        outputConsole(sampleService3);

        // sample 4 (SampleServiceInterfaceの実装 + インスタンス作成 → メソッド呼び出し)
        // lambda式
        // 引数が1つの場合のみ、引数ブロック(`()`)の省略可
        SampleArgsService sampleService4 = s -> System.out.println(s + "(lambda)");
        outputConsole(sampleService4);
    }

    private void outputConsole(SampleArgsService sampleArgsService) {
        sampleArgsService.accept("execute Sample Service");
    }
}
