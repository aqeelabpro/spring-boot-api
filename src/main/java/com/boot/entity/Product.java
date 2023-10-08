package com.boot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private String price;

}
