package com.mycode.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckHistoryService fraudCheckHistoryService;


    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        boolean isFraudulet = fraudCheckHistoryService.isFraudCustomer(customerId);
        return new FraudCheckResponse(isFraudulet);
    }
}
