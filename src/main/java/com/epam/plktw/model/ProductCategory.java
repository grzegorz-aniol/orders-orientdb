package com.epam.plktw.model;

import lombok.Data;
import lombok.Getter;
import lombok.val;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Id;
import javax.persistence.Version;

@Data
public class ProductCategory {

    public static final String PATH_SEPARATOR = "/";
    
    @Id
    private String id;
    
    @Version
    private long version;
    
    private String categoryName;
    
    @Getter
    private String categoryPath;
        
    private ProductCategory upperCategory;
    
    public void setCategoryName(final String name) {
        this.categoryName = name;
        updatePath();
    }
    
    public void setUpperCategory(ProductCategory upperCategory) {
        this.upperCategory = upperCategory;
        updatePath();
    }
    
    private void updatePath() {
        
        ProductCategory item = this;
        val list = new LinkedList<String>();
        while(item != null) {
            if (item != null) {
                list.addFirst(item.getCategoryName());
                list.addFirst(PATH_SEPARATOR);
            }
            item = item.getUpperCategory();
        }

        this.categoryPath = list.stream().collect(Collectors.joining());
    }

    public static class Builder {
        
        private ProductCategory wrapper = new ProductCategory();
        
        public Builder id(final String id) {
            wrapper.setId(id);
            return this; 
        }
        
        public Builder categoryName(final String name) {
            wrapper.setCategoryName(name);
            return this; 
        }
        
        public Builder parent(ProductCategory parent) {
            wrapper.setUpperCategory(parent);
            return this; 
        }
        
        public ProductCategory build() {
            return this.wrapper; 
        }
        
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
}
