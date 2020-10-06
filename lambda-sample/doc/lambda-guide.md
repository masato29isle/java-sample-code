
# Lambda式について

## Lambda式とは？

* 以下の手順を簡略化できる手法のこと
  1. インターフェースを実装
  2. 実装したインターフェースのメソッド処理を定義
  3. インターフェースを実装したクラスをインスタンス化(new)する
  4. メソッドを呼び出す

* 使用するための制約
   1. インターフェースに定義されているメソッドが一つであること  


## 手順を簡略化しない例

```java
public interface Sample {
    void execute();
}

// 手順１
public class SampleImpl implements Sample {
    // 手順２
    @Override
    public void execute() {
        System.out.println("Sample!!");
    }
}

public class LambdaSample {
    public static void main(String[] args) {
        // 手順3
        Sample sample1 = new SampleImpl();
        // 手順4
        sample1.execute();
    }
}
```

## 手順を簡略化した例(匿名クラスを使用)

```java
public interface Sample {
    void execute();
}

public class LambdaSample {
    public static void main(String[] args) {
        // 手順2 + 手順3
        // 匿名クラスにすることで手順1を省略できる
        Sample sample1 = new Sample() {
            @Override
            public void execute() {
                System.out.println("Sample!");
            }
        };
        // 手順4
        sample1.execute();
    }
}
```


## 手順を簡略化した例(lambdaを使用)

```java
public interface Sample {
    void execute();
}

public class LambdaSample {
    public static void main(String[] args) {
        // 手順1を省略
        // 手順2 + 手順3 を簡略化
        Sample sample1 = () -> System.out.println("Sample Lambda!");
        // 手順4
        sample1.execute();
    }
}
```

## Lambda式の構文

(`引数`) -> {`処理内容`}

```java
@FunctionalInterface
public interface Consumer<T> {
  void accept(T t);
}

public class LambdaSample {
    public static void main(String[] args) {
        Consumer<String> consumer = (str) -> {  
            System.out.println(str);
        };
        // "lambda-consumer"と出力される
        consumer.accept("lambda-consumer");
    }
}
```

### 補足
* `@FunctionalInterface`は一つしかメソッドが定義されていないことを明示するためのアノテーション
* 上記アノテーションが付与されているインターフェースにメソッドを追加するとコンパイルエラーになる


## 頻出する関数型インターフェース

| インターフェース | 引数 | 戻り値 |
| :---: | :--- | :--- |
|Function|T(型パラメータにて指定)|R(型パラメータにて指定)|  
|Consumer|T(型パラメータにて指定)|-|  
|Predicate|T(型パラメータにて指定)|boolean|  d

その他の関数型インターフェースおよび詳細については以下リンク参照のこと  
[JDK11 APIリファレンス(java.util.functionパッケージ)](https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/function/package-summary.html)
