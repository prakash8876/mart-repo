package io.matoshri.mart.customer.mapper;

import io.matoshri.mart.customer.beans.Customer;
import io.matoshri.mart.customer.beans.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private CustomerMapper(){}

    public Customer mapToCustomer(CustomerDTO dto) {
        return new Customer(dto.getName(), dto.getEmail(), dto.getMobile());
    }

    public CustomerDTO mapToDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getMobile());
    }
}
