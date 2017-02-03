package com.epam.plktw.repos;

import com.epam.plktw.model.Order;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends OrientObjectRepository<Order> {

}
