package io.matoshri.customer.controller;

import io.matoshri.customer.beans.CustomerDTO;
import io.matoshri.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        log.debug("Getting all Customers");
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping(value = "email", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@RequestParam(name = "email") String email) {
        log.debug("Getting Customer by Email {}", email);
        return ResponseEntity
                .ok(service.getCustomerByEmail(email));
    }

    @GetMapping(value = "id", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerDTO> getCustomerById(@RequestParam(name = "id") Integer customerId) {
        log.debug("Getting Customer by ID {}", customerId);
        return ResponseEntity
                .ok(service.getCustomerById(customerId));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Integer> saveCustomer(@RequestBody @Validated CustomerDTO customerDTO) {
        log.debug("Saving Employee {}", customerDTO);
        return ResponseEntity
                .ok(service.saveCustomer(customerDTO));
    }
}
