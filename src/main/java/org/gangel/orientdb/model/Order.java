package org.gangel.orientdb.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import javax.money.MonetaryAmount;
import javax.persistence.Id;
import javax.persistence.Version;

@Data
@Builder
public class Order {

    @Id
    private String id;
    
    @Version
    private long version;
    
    private LocalDate orderCreated;
    
    private boolean isPaid; 
    
    private long totalPriceInPips;
    
    private MonetaryAmount totalPrice;
    
    private Customer customer;
    
    private List<Product> products;
    
}
