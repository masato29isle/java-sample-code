# Optionalについて

## Optionalとは？

* Optionalはオブジェクトをラップし、そのオブジェクトがNullかもしれないことを表現する為のクラス
  * なので、Optionalでラップされたオブジェクトが戻り値であるメソッドの呼び出し側でNullである可能性を意識して処理してもらうことができる

## Optionalの使い方

### 呼び出し先
* オブジェクトをOptionalクラスのFactoryメソッドを呼び出して対象のオブジェクトのラップを行う

| メソッド | 引数 | 戻り値 |
| :--- | :--- | :--- |
|ofNullable|T(型パラメータにて指定)|Optional\<T>|  
|of|T(型パラメータにて指定)|Optional\<T>|  

```java
// Nullの可能性があることを示すOptional型のオブジェクトを返す
return Optional.ofNullable(getXxx());

// ラップしたオブジェクトがNullの場合、NullPointerExceptionをスローする
// 基本Nullで有る可能性があることを示すものなので、ほとんど使用しない
// 呼び出し元で意識はさせない
return Optional.of(getXxx());
```

### 呼び出し元
* Optional型でラップされた値を取り出す（Nullとそれ以外の場合の戻り値を設定する）

| メソッド(引数) | 戻り値 | 説明 |
| :--- | :--- | :--- |
|get|T(型パラメータにて指定)|ラップ元の値を取得する|  
|orElse(T)|T(型パラメータにて指定)|ラップ元の値を取得する<br/>Nullである場合は引数で指定したオブジェクトを返す|  
|orElseGet(Supplier\<T>)|T(型パラメータにて指定)|ラップ元の値を取得する<br/>Nullである場合は引数で指定した関数結果を返す|  
|orElseThrow(Supplier\<Throwable>)|T(型パラメータにて指定)|ラップ元の値を取得する<br/>Nullである場合は引数で指定した関数結果を返す(例外スローする)| 

```java
// Nullの場合はNullPointerExceptionが発生する
// Nullではないことを確認済or自明の場合のみ使用
String xxx = SampleService.getXxx().get();

// Nullの場合は引数に渡したオブジェクトを戻り値とする
String xxx = SampleService.getXxx().orElse("DEFALUT");

// Nullの場合は引数に渡した関数結果を戻り値とする
String yyy = "default";
String xxx = SampleService.getXxx().orElseGet(() -> yyy.toUpperCase());

// Nullの場合は指定した例外を発生させる
// 例外のスローはできる限り呼び出し元で行うべきなので、多用すべきではない
String xxx = SampleService.getXxx().orElseThrow(() -> new IllegalstateException("不正状態です"));
```

* Optional型のオブジェクトを操作する

| メソッド(引数) | 戻り値 | 説明 |
| :--- | :--- | :--- |
|ifPresent(Consumer\<T>)|-|Nullでない場合は引数で指定した関数を実行する|  
|map(Function\<T,R>)|Optional\<R>(型パラメータにて指定)|Nullでない場合はOptionalでラップした関数結果を返す|  

```java
// Nullではない場合、取得した値をコンソールに出力
String xxx = SampleService.getXxx().ifPresent(System.out::println);

// Nullではない場合、取得した値を変換した結果をOptionalでラップする
// Stream-APIとセットで使用する場合がほとんど
String yyy = "default";
Optional<String> xxxOpt = SampleService.getXxx().map(xxx -> xxx::toUpperCase);
```

その他メソッドおよび詳細については以下参照  
[JDK11 APIリファレンス(Optionalクラス)](https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/Optional.html)

## Optionalの使用有無によるコード比較

* Optional を使用しない場合

```java
public class NonOptionalService {
    @Inject
    private OrderRepository orderRepository;

    @Inject
    private BalanceRepository balanceRepository;

    /**
     * 指定した注文の金額を取得する その1
     */
    public int getOrderPrice(String orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order != null) {
            return order.getPrice();
        } else {
            throw new IllegalArgumentException("指定された注文情報は存在しません");
        }
    }

    /**
     * 指定した注文金額分を残高に追加する その2
     */
    public void addBalance(String orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order != null) {
            balanceRepository.insert(order.getPrice());
        }
    }

}

public interface OrderRepository {
    @Select("SELECT * FROM ORDERS WHERE orderId = #{orderId}")
    Optional<Order> getOrder(String orderId);
}

public interface BalanceRepository {
    @Insert("INSERT INTO BALANCES VALUES (#{price})")
    void insert(int price);
}
```

* Optional を使用した場合

```java
public class OptionalService {
    @Inject
    private OrderRepository orderRepository;

    @Inject
    private BalanceRepository balanceRepository;

    /**
     * 指定した注文の金額を取得する その1
     */
    public int getOrderPrice(String orderId) {
        Order order = orderRepository.getOrder(orderId)
                        .orElseThrow(() -> new IllegalArgumentException("指定された注文情報は存在しません"));
        return order.getPrice();
    }

    /**
     * 指定した注文金額分を残高に追加する その2
     */
    public void addBalance(String orderId) {
        orderRepository.getOrder(orderId).ifPresent(order -> {
            balanceRepository.insert(order.getPrice());
        });
    }

    /**
     * 指定した注文の金額を取得する その3（良くない例）
     */
    public int getOrderPrice(String orderId) {
        Optional<Order> orderOpt = orderRepository.getOrder(orderId);
        if (orderOpt.isPresent()) {
            return orderOpt.get().getPrice();
        } else {
            throw new IllegalArgumentException("指定された注文情報は存在しません");
        }
    }

}

public interface OrderRepository {
    @Select("SELECT * FROM ORDERS WHERE orderId = #{orderId}")
    Optional<Order> getOrder(String orderId);
}

public interface BalanceRepository {
    @Insert("INSERT INTO BALANCES VALUES (#{price})")
    void insert(int price);
}
```