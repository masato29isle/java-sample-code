package com.github.masato29isle.sample.service;

/**
 * Lambda-sample-interface(戻り値なし-引数あり)
 */
@FunctionalInterface
public interface SampleArgsService {
    void accept(String s);
}
