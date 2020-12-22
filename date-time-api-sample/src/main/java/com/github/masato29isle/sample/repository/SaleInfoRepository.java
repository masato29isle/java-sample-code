package com.github.masato29isle.sample.repository;

import java.time.LocalDateTime;
import java.util.Optional;

public class SaleInfoRepository {
    public Optional<LocalDateTime> getFinalSaleTime(String storeId) {
        return Optional.ofNullable(LocalDateTime.of(2020,12,12,10,45));
    };
}
