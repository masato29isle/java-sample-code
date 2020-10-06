package com.github.masato29isle.sample;

import com.github.masato29isle.sample.service.SampleReturnValueService;
import com.github.masato29isle.sample.service.SampleReturnValueServiceImpl;

/**
 * Supplier型Lambdaサンプル実行クラス
 */
public class LambdaExecutionSupplier implements LambdaExecution {
    @Override
    public void execute() {
        // sample 1 (SampleReturnValueServiceの実装クラス作成 → インスタンス作成 → メソッド呼び出し)
        SampleReturnValueService sampleService1 = new SampleReturnValueServiceImpl();
        outputConsole(sampleService1);

        // sample 2 (SampleReturnValueServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // 匿名クラス
        SampleReturnValueService sampleService2 = new SampleReturnValueService() {
            @Override
            public String get() {
                return "(Anonymous)";
            }
        };
        outputConsole(sampleService2);

        // sample 3 (SampleReturnValueServiceの実装 + インスタンス作成 → メソッド呼び出し)
        // lambda式
        SampleReturnValueService sampleService3 = () -> { return "(lambda)"; };
        outputConsole(sampleService3);

        // sample 4
        // lambda式
        // return statementも省略可(処理が一文の場合のみ)(処理ブロック({})の省略とセットで実施)
        SampleReturnValueService sampleService4 = () -> "(lambda2)";
        outputConsole(sampleService4);
    }

    /**
     * コンソールに標準出力を行う
     *
     * @param sampleReturnValueService lambda関数(引数なし 戻り値あり)
     */
    private void outputConsole(SampleReturnValueService sampleReturnValueService) {
        System.out.println("execute Sample Service" + sampleReturnValueService.get());
    }
}
