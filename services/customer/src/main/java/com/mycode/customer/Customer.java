package com.mycode.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_Id",sequenceName = "customer_Id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "customer_Id_sequence")
    private Integer id;
    private String firstName;
    private  String lastName;
    private String email;
}
