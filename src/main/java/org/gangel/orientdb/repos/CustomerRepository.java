package org.gangel.orientdb.repos;

import org.gangel.orientdb.model.Customer;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends OrientObjectRepository<Customer> {

}
