package io.matoshri.mart.invoicedetails;

import io.matoshri.mart.product.Product;
import lombok.Data;

import javax.persistence.OneToMany;

@Data
public class InvoiceDetails {
    @OneToMany
    private Product product;
    private int quantity;
    private double amount;
    private double total;
}
