package com.epam.plktw.repos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.epam.plktw.InspectObj;
import com.epam.plktw.OrdersOrientdbApplication;
import com.epam.plktw.model.Address;
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
public class AddressRepoTest extends RepositoryTestsBase<Address, AddressRepository>{


    @Test
    public void addNewRandomAddress() {
        assertNotNull(repo);
        Address adr = random.nextObject(Address.class,"id");
        assertNotNull(adr);
        adr = repo.save(adr);
        assertNotNull(adr);
    }

    @Test
    public void getFirstAddress() {
        assertNotNull(repo);
        
        inspect = new InspectObj<>(factory.db());
        
        Optional<Address> adr = repo.findAll().stream()
                    .map(inspect::print)
                    .findFirst();
        
        assertTrue(adr.isPresent());
    }
    
    @Test
    public void getAllAddresses() {
        assertNotNull(repo);
        
        InspectObj<Address> inspect = new InspectObj<>(factory.db());
        
        long count = repo.findAll().stream()
                    .map( inspect::print )
                    .count();
        
        System.out.println(count);
        
    }    
    
    
}




