package org.gangel.orientdb.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.val;

import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.persistence.Id;
import javax.persistence.Version;

@Data
@Builder
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

    
}
