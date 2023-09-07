package io.matoshri.mart.customer.service;

import io.matoshri.mart.customer.beans.Customer;
import io.matoshri.mart.customer.beans.CustomerDTO;
import io.matoshri.mart.customer.mapper.CustomerMapper;
import io.matoshri.mart.customer.repo.CustomerRepository;
import io.matoshri.mart.exception.EmailExistsException;
import io.matoshri.mart.exception.ResourceNotFoundException;
import io.matoshri.mart.utils.Constants;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repo;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repo,
                               CustomerMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<CustomerDTO> getAllCustomers() {
        return repo.findAll().stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(int customerId) {
        return mapper.mapToDTO(repo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_NOT_FOUND + " " + customerId)));
    }

    public CustomerDTO getCustomerByEmail(String email) {
        Customer customer = repo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_NOT_FOUND + " " + email));
        return mapper.mapToDTO(customer);
    }

    @Override
    public CustomerDTO getCustomerByMobile(String mobile) {
        Customer customer = repo.findByMobile(mobile).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_NOT_FOUND + " " + mobile));
        return mapper.mapToDTO(customer);
    }

    @Transactional
    public int saveCustomer(CustomerDTO customerDTO) {
        if (StringUtils.isNotEmpty(customerDTO.getEmail())
                && repo.findByEmail(customerDTO.getEmail()).isPresent()) {
            throw new EmailExistsException(Constants.EMAIL_EXISTS + " " + customerDTO.getEmail());
        }
        Customer customer = mapper.mapToCustomer(customerDTO);
        Customer savedCustomer = repo.save(customer);
        log.info("Customer saved {}", savedCustomer.getId());
        return savedCustomer.getId();
    }

    @Transactional
    public int updateCustomer(int customerId, CustomerDTO customerDTO) {
        Customer customer = repo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_NOT_FOUND));
        if (StringUtils.isNotEmpty(customerDTO.getName())) customer.setName(customerDTO.getName());
        if (StringUtils.isNotEmpty(customerDTO.getEmail())) customer.setEmail(customerDTO.getEmail());
        if (StringUtils.isNotEmpty(customerDTO.getMobile())) customer.setMobile(customerDTO.getMobile());
        repo.save(customer);
        log.info("Customer updated {}", customerId);
        return customerId;
    }

    @Transactional
    public int deleteCustomerById(int customerId) {
        Customer customer = repo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException(Constants.CUSTOMER_NOT_FOUND));
        repo.delete(customer);
        log.info("Deleted Customer {}", customerId);
        return customerId;
    }

    public long countCustomers() {
        return repo.count();
    }
}
