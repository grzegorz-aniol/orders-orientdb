package org.gangel.orientdb.repos;

import org.gangel.orientdb.model.ProductCategory;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends OrientObjectRepository<ProductCategory> {

    public String CATEGORY_ROOT_NAME = "ALL";
    public String CATEGORY_ROOT_PATH = "/ALL";

    public ProductCategory findByCategoryNameIgnoreCase(String categoryName);
    
    public ProductCategory findByCategoryPathIgnoreCase(String categoryPath);
    
}
