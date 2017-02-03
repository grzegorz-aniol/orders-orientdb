package com.epam.plktw.repos;

import com.epam.plktw.model.Customer;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends OrientObjectRepository<Customer> {

}
