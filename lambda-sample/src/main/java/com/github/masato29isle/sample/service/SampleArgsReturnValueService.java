package com.github.masato29isle.sample.service;

/**
 * Lambda-sample-interface(戻り値あり-引数あり)
 */
@FunctionalInterface
public interface SampleArgsReturnValueService {
    String apply(String str);
}
