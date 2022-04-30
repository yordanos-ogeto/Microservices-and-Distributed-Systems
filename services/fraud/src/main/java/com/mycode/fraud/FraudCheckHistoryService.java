package com.mycode.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
        .customerId(customerId)
        .isFraudster(false)
        .localDate(LocalDate.now())
        .build());
        return false;
    }
}
