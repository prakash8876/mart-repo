package io.matoshri.mart.invoice;

import io.matoshri.mart.customer.beans.CustomerDTO;
import io.matoshri.mart.invoicedetails.InvoiceDetails;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Invoice {
    private int year;
    private int number;
    private Date date;

    @ManyToOne
    private CustomerDTO customer;

    @ElementCollection
    private List<InvoiceDetails> details = new ArrayList<>();
}
