package com.epam.plktw.repos;

import static org.junit.Assert.assertNotNull;

import com.epam.plktw.OrdersOrientdbApplication;
import com.epam.plktw.model.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=OrdersOrientdbApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProductCategoryRepoTest extends RepositoryTestsBase<ProductCategory, ProductCategoryRepository> {

    private ProductCategory rootProductCategory;
    
    private ProductCategory root() {
        if (rootProductCategory != null) {
            return rootProductCategory;
        }
        rootProductCategory = repo.findByCategoryPathIgnoreCase(ProductCategoryRepository.CATEGORY_ROOT_PATH);
        if (rootProductCategory != null) {
            return rootProductCategory;
        }
        rootProductCategory = ProductCategory.builder().categoryName(ProductCategoryRepository.CATEGORY_ROOT_NAME).build();
        rootProductCategory = repo.save(rootProductCategory);
        return rootProductCategory; 
    }
    
    protected ProductCategory producer() {
        return producer(null);
    }    
    protected ProductCategory producer(ProductCategory parent) {
        ProductCategory pc = ProductCategory.builder().categoryName(fairy.textProducer().latinWord(4)).build();
        pc.setUpperCategory(parent);
        
        return pc;
    }
    
    @Test
    @Repeat(10)
    public void addNewCategory() {
        assertNotNull(repo);
        
        ProductCategory root = root();
        assertNotNull(root);
        
        ProductCategory pc = producer();
        assertNotNull(pc);
        
        pc = repo.save(pc);
        assertNotNull(pc);
        
    }
    
    @Test
    @Repeat(10)
    public void addNewChainedCategories() {
        assertNotNull(repo);
        
        ProductCategory root = root();
        assertNotNull(root);
        
        ProductCategory pc1 = producer();
        assertNotNull(pc1);
        pc1 = repo.save(pc1);        
        assertNotNull(pc1);
        
        ProductCategory pc2 = producer(pc1);
        assertNotNull(pc2);
        pc2 = repo.save(pc2);        
        assertNotNull(pc2);

        ProductCategory pc3 = producer(pc2);
        assertNotNull(pc3);
        pc3 = repo.save(pc3);        
        assertNotNull(pc3);
        
    }    
    
    @Test
    @Repeat(3)
    public void addNewChainedCategories2() {
        assertNotNull(repo);
        
        ProductCategory root = root();
        assertNotNull(root);
        
        IntStream        
            .range(1,3)
            .mapToObj( (a) -> producer() )
            .peek((a) -> assertNotNull(a))
            .reduce(root(), (a, b) -> producer(a) );
        
    }     
    
}
