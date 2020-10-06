package com.github.masato29isle.sample;

import com.github.masato29isle.sample.service.SampleArgsReturnValueService;
import com.github.masato29isle.sample.service.SampleArgsReturnValueServiceImpl;

/**
 * Function型Lambdaサンプル実行クラス
 */
public class LambdaExecutionFunction implements LambdaExecution {
    @Override
    public void execute() {
        // sample 1 (SampleArgsReturnValueServiceの実装クラス作成 → インスタンス作成 → メソッド呼び出し)
        SampleArgsReturnValueService sampleService1 = new SampleArgsReturnValueServiceImpl();
        outputConsole(sampleService1);

        // sample 2 (SampleArgsReturnValueServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // 匿名クラス
        SampleArgsReturnValueService sampleService2 = new SampleArgsReturnValueService() {
            @Override
            public String apply(String str) {
                return str + "(Anonymous)";
            }
        };
        outputConsole(sampleService2);


        // sample 3 (SampleArgsReturnValueServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // lambda式
        SampleArgsReturnValueService sampleService3 = (str) -> { return str + "(lambda)"; };
        outputConsole(sampleService3);

        // sample 4
        // lambda式
        // return statementの省略 + 引数ブロックの省略
        SampleArgsReturnValueService sampleService4 = str -> str + "(lambda2)";
        outputConsole(sampleService4);
    }

    /**
     * コンソールに標準出力を行う
     *
     * @param sampleArgsReturnValueService lambda関数(引数あり 戻り値あり)
     */
    private void outputConsole(SampleArgsReturnValueService sampleArgsReturnValueService) {
        System.out.println(sampleArgsReturnValueService.apply("execute Sample Service"));
    }
}
