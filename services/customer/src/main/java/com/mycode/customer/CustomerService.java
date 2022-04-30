package com.mycode.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

       private CustomerRepository customerRepository;
        private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName)
                .lastName(request.lastName)
                .email(request.email).build();
        //todo: store customer in db
        customerRepository.save(customer);

        //todo: check if email valid
        //todo: check if email not taken

        FraudCheckResponse fraudCheckResponse=    restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,customer.getId());
if(fraudCheckResponse.isFraudster){
    throw new IllegalStateException("fraudster");
}
    }
}
