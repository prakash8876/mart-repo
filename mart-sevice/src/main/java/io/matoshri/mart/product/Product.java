package io.matoshri.mart.product;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;
    private String description;
    private double unitPrice;
}
