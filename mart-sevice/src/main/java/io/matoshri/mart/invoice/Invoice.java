package io.matoshri.mart.invoice;

import io.matoshri.mart.customer.beans.CustomerDTO;
import io.matoshri.mart.invoicedetails.InvoiceDetails;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {
    @Id
    @NonNull
    private int number;
    private int year;
    private Date date;

    @ManyToOne
    private CustomerDTO customer;

    @ElementCollection
    private List<InvoiceDetails> details = new ArrayList<>();
}
