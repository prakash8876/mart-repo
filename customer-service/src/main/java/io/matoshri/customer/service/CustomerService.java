package io.matoshri.customer.service;

import io.matoshri.customer.beans.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(int customerId);
    CustomerDTO getCustomerByEmail(String email);
    CustomerDTO getCustomerByMobile(String mobile);

    int saveCustomer(CustomerDTO customerDTO);

    int updateCustomer(int customerId, CustomerDTO customerDTO);

    int deleteCustomerById(int customerId);

    long countCustomers();

    void loadFromJson(String fileName);
}
