package io.matoshri.mart.customer.service;


import io.matoshri.mart.customer.beans.CustomerDTO;

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
}
