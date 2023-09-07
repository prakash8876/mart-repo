package io.matoshri.mart.customer.beans;

import lombok.Data;

import javax.validation.constraints.Email;
import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    private Integer id;
    private String name;
    @Email(message = "enter proper email address.")
    private String email;
    private String mobile;

    public CustomerDTO() {}

    public CustomerDTO(Integer id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}
