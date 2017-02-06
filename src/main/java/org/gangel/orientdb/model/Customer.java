package org.gangel.orientdb.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Version;

@Data
@Builder
public class Customer {

    @Id
    private String id;
    
    @Version
    private long version;    
    
    private String name;
    
    private String firstName;
    
    private String lastName;
    
    private String contactEmail; 
    
    private LocalDate createdAt;
    
    private LocalDate modifiedAt;
    
    private List<Address> addresses; 
    
}
