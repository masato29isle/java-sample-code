package com.github.masato29isle.sample.repository;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class SaleInfoRepository2 {
    public Optional<Date> getFinalSaleTime(String storeId) {
        Calendar targetDateTime = Calendar.getInstance();
        targetDateTime.set(2020,Calendar.DECEMBER,12,12,45);

        return  Optional.ofNullable(targetDateTime.getTime());
    }
}
