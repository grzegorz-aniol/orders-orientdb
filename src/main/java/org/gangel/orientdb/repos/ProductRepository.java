package org.gangel.orientdb.repos;

import org.gangel.orientdb.model.Product;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends OrientObjectRepository<Product> {

}
