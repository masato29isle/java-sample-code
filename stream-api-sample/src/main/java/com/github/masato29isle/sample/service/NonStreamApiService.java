package com.github.masato29isle.sample.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Non-Stream-API-実行サービス
 */
public class NonStreamApiService implements SampleService {
    @Override
    public List<String> execute(List<String> targetList) {
        // 処理結果を格納する変数の定義
        List<String> resultList = new ArrayList<>();

        // イテレーション処理を行い、条件に合致するものをListに追加
        for (String value : targetList) {
            if (value != null && value.endsWith("test") && !resultList.contains(value)) {
                resultList.add(value);
            }
        }

        // 処理結果を返却
        return resultList;
    }
}
