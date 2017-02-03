package com.epam.plktw.repos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.epam.plktw.OrdersOrientdbApplication;
import com.epam.plktw.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=OrdersOrientdbApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProductRepoTest extends RepositoryTestsBase<Product, ProductRepository> {

    @Test
    public void addNewProduct() {
        assertNotNull(repo);
        Product adr = random.nextObject(Product.class, "id");
        assertNotNull(adr);
        adr = repo.save(adr);
        assertNotNull(adr);
    }

    @Test
    public void getFirstProduct() {
        assertNotNull(repo);
        
        Optional<Product> adr = repo.findAll().stream()
                    .map(inspect::print)
                    .findFirst();
        
        assertTrue(adr.isPresent());
    }
    
    @Test
    public void getAllProducts() {
        assertNotNull(repo);
        
        long count = repo.findAll().stream()
                    .map( inspect::print )
                    .count();
        
        System.out.println(count);
        
    }    
    
    
}




