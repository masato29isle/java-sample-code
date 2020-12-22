# Date-Time-APIについて

## Date-Time-APIとは？

* Java8から登場した、日付表現及び操作を行なうためのクラス

特徴としては以下の通り
  * イミュータブルにオブジェクトを使用することができる
    * 内部の情報を変更しない
      * 意図しない変更を防ぐことができる
  * 日付の計算処理（加算・減算・比較）が簡単に行える

なので、戻り値がDate型やCalendar型だったものはLocalDateやLocalDateTime型にすると使い勝手が良くなる＆安全にオブジェクトを使用することできる
 
## Date-Time-APIの使い方

### オブジェクトの生成/取得

```java
// LocalDate
// 現在日取得
LocalDate currentDate = LocalDate.now();
// 指定した日付を取得
LocalDate targetDate = LocalDate.of(2020,12,21);


// LocalTime
// 現在時間取得
LocalTime currentTime = LocalTime.now();
// 指定した時間を取得
LocalTime targetTime = LocalTime.of(12,45);

// LocalDateTime
// 現在日時取得
LocalDateTime currentDateTime = LocalDateTime.now();
// 指定した日時を取得
LocalDateTime targetDateTime = LocalDateTime.of(2020,12,21);
```

### 日付・日時の加算/減算

```java
// LocalDate
// 指定日付から2週間後の日付を取得
// 2021-01-04
LocalDate targetAfterDate = LocalDate.of(2020,12,21).plusWeeks(2);
// 指定日付から2週間前の日付を取得
// 2020-12-07
LocalDate targetBeforeDate = LocalDate.of(2020,12,21).minusWeeks(2);


// LocalTime
// 指定日付から2時間後の日付を取得
// 14:45
LocalTime targetAfterTime = LocalTime.of(12,45).plusHours(2);
// 指定日付から2時間前の日付を取得
// 10:45
LocalDate targetBeforeTime = LocalTime.of(12,45).minusHours(2);

// LocalDateTime
// 指定日付から2週間後の日付を取得
// 2021-01-04 00:00:00
LocalDate targetAfterDate = LocalDate.of(2020,12,21).plusWeeks(2);
// 指定日付から2時間前の日付を取得
// 2020-12-20 22:00:00
LocalDate targetBeforeDate = LocalDate.of(2020,12,21).minusHours(2);
```

その他使い方よび詳細については以下参照  
[JDK11 APIリファレンス(LocalDateクラス)](https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/time/LocalDate.html)  
[JDK11 APIリファレンス(LocalTimeクラス)](https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/time/LocalTime.html)  
[JDK11 APIリファレンス(LocalDateTimeクラス)](https://docs.oracle.com/javase/jp/11/docs/api/java.base/java/time/LocalDateTime.html)  

## Date-Time-APIの使用有無によるコード比較

* Date-Time-API を使用しない場合

```java
public class NonDateTimeApiService {
    @Inject
    private SaleInfoRepository saleInfoRepository;

    /**
     * 指定した店舗が1週間以上売上が発生していないか判定する
     */
    public boolean checkNotSaleMoreThanOneWeek(String storeId) {
        Date finalSalesDateTime = saleInfoRepository.getFinalSaleTime(storeId)
                                    .orElseThrow(() -> new IllegalArgumentException("指定された店舗情報は存在しません"));
        
        Calendar currentDateTime = Calendar.getInstance();
        currentDateTime.set(Calendar.HOUR_OF_DAY, 0);
        currentDateTime.clear(Calendar.MINUTE);
        currentDateTime.clear(Calendar.SECOND);
        currentDateTime.clear(Calendar.MILLISECOND);
        
        long diffMilliTime = currentDateTime.getTimeInMillis() - finalSalesDateTime.getTime();
        long diffDay = diffMilliTime / (1000 * 60 * 60 * 24)

        if ( diffDay >= 7 ) {
            return true;
        } else {
            return false;
        }
    }

}

public interface SaleInfoRepository {
    @Select("SELECT update_time FROM SALES WHERE storeId = #{saleId} ORDER BY update_time desc limit 1")
    Optional<Date> getFinalSaleTime(String storeId);
}
```

* Date-Time-API を使用した場合

```java
public class DateTimeApiService {
    @Inject
    private SaleInfoRepository saleInfoRepository;

    /**
     * 指定した店舗が1週間以上売上が発生していないか判定する
     */
    public boolean checkNotSaleMoreThanOneWeek(String storeId) {
        LocalDateTime finalSalesDateTime = saleInfoRepository.getFinalSaleTime(storeId)
                                             .orElseThrow(() -> new IllegalArgumentException("指定された店舗情報は存在しません"));

        return finalSalesDateTime.isBefore(LocalDateTime.now()
                                             .minusWeeks(1)
                                             .truncatedTo(ChronoUnit.DAYS));
    }

}

public interface SaleInfoRepository {
    @Select("SELECT update_time FROM SALES WHERE storeId = #{saleId} ORDER BY update_time desc limit 1")
    Optional<LocalDateTime> getFinalSaleTime(String storeId);
}

```