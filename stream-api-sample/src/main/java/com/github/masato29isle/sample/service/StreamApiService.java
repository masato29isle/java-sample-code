package com.github.masato29isle.sample.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Stream-API-実行サービス
 */
public class StreamApiService implements SampleService {
    @Override
    public List<String> execute(List<String> targetList) {
        return targetList.stream() // Streamの生成
                .filter(Objects::nonNull) // NotNullでフィルタリング　
                .filter(value -> value.endsWith("test")) // Suffix="test"でフィルタリング
                .distinct() // 重複要素を削除
                .collect(Collectors.toUnmodifiableList()); // 中間操作済みCollectionを返却
    }
}
