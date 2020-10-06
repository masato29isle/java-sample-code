
# Lambdaサンプル実行方法変更

## 変更方法

* 以下変更を実施する
```java
public class LambdaSample {

    public static void main(String[] args) {
        // 引数チェック処理をコメントアウト
        // if (args.length == 0) {
        //     throw new IllegalStateException("実行時引数が存在しません");
        // }
        
        // 引数に実行カテゴリを直接渡す形にするよう修正
        // ExecutionCategory.getByValue(args[0]) → ExecutionCategory.RUNNABLE
        execute(ExecutionCategory.RUNNABLE);
    }

    /** 途中省略 */
}
```