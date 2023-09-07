package io.matoshri.customer.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_id", length = 10)
    private Integer id;

    @Column(name = "customer_name", length = 20)
    private String name;
    @Column(name = "customer_email", length = 50, unique = true)
    private String email;
    @Column(name = "customer_mobile", length = 10, unique = true)
    private String mobile;

    public Customer() {}

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}