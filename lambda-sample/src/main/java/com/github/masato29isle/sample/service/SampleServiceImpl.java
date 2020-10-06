package com.github.masato29isle.sample.service;

/**
 * Lambda-sample-implements-class(戻り値なし-引数なし)
 */
public class SampleServiceImpl implements SampleService {
    @Override
    public void execute() {
        System.out.println("execute Sample Service");
    }
}
