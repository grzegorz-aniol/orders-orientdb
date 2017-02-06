package org.gangel.orientdb.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Version;

@Data
@Builder
public class Address implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1333479903142942680L;

    @Id
    private String id;
    
    @Version
    private long version;
    
    private String country;
    
    private String city;
    
    private String postCode;
    
    private String street; 
    
    private String houseNumber;
    
    private String appartmentNumber;


    
}
