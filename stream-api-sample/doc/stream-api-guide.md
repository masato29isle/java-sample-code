# Stream-APIについて

## Stream-APIとは？

* コレクション※1操作の記述を簡潔にしてくれるメソッド群を提供するAPIのこと  
  ※1 List、Setなど複数のオブジェクトを一つのオブジェクトとして扱うクラス群
  
* 処理の記述が宣言的になるので、コードの可読性が上がりやすくなることが多い
  * イテレーション処理内で何を行いたいかという部分にのみフォーカスを与えることができる

## Stream-APIの使い方

1. コレクションからStreamを生成
    * Collectionインターフェースを実装しているクラスオブジェクトの場合 → stream()を呼び出す
    * 配列の場合 → Arrays.stream(`配列変数`)を呼び出す
2. 中間操作を行う
    * 複数行うことが可能
3. 終端操作を行う
    * これまで行った操作結果のStreamオブジェクトに対して、Stream以外の結果を返す処理を行う

### 頻出するStreamの中間操作

| メソッド名 | 概要 | 引数 | 戻り値 |
| :---: | :--- | :--- | :--- |
|filter|定義した関数の実行結果がfalseの場合<br/>要素を削除|Predicate<? super T>|Stream\<T>|  
|map|Stream\<T>を関数の実行結果をもとに<br/>Stream\<R>に変換する|Function<? super T,​? extends R>|Stream\<R>|  
|sorted|定義した条件でソートしたStreamに変換する|Comparator<? super T>|Stream\<T>|  

### 頻出するStreamの終端操作

| メソッド名 | 概要 | 引数 | 戻り値 |
| :---: | :--- | :--- | :--- |
|forEach|各要素に対して定義した関数を実行する|Consumer<? super T>|void|  
|collect|Stream内要素を一つにまとめた結果を返す|Collector<? super T,​A,​R>|R(一つにまとめた結果)|  
|anyMatch<br/>allMatch<br/>noneMatch|条件式を満たす要素がひとつでもある場合<br/>すべての要素が条件式を満たす場合<br/>ひとつも満たさない場合|Predicate<? super T>|boolean|  

その他メソッドおよび詳細については以下参照  
[JDK11 APIリファレンス(Streamインターフェース)](https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/util/stream/Stream.html)

## Stream-APIの使用有無によるコード比較

* Stream API を使用しない場合

```java
public class NonStreamApiService {
    public List<String> execute(List<String> targetList) {
        // 処理結果を格納する変数の定義
        List<String> resultList = new ArrayList<>();        
        
        // イテレーション処理を行い、条件に合致するものをListに追加
        for (String value : targetList) {
            if (value != null && value.endsWith("test")) {
                resultList.add(value);
            }
        }

        // 処理結果を返却
        return resultList;
    }
}
```

* Stream API を使用した場合

```java
public class StreamApiService {
    public List<String> execute(List<String> targetList) {
        return targetList.stream() // Streamの生成
                .filter(Objects::nonNull) // NotNullでフィルタリング　
                .filter(value -> value.endsWith("test")) // Suffix="test"でフィルタリング
                .collect(Collectors.toUnmodifiableList()); // 中間操作済みCollectionを返却
    }
}
```


