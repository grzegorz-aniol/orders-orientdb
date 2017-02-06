package org.gangel.orientdb.repos;

import org.gangel.orientdb.model.Order;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends OrientObjectRepository<Order> {

}
