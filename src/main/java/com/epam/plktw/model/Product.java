package com.epam.plktw.model;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.Id;
import javax.persistence.Version;

@Data
public class Product {

    @Id
    private String id; 
    
    @Version
    private long version;
    
    private String name;

    private String description;
    
    private long priceInPips;
    
    private LocalDate priceChange;
    
    private ProductCategory category;
}
