package com.epam.plktw.repos;

import com.epam.plktw.model.Product;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends OrientObjectRepository<Product> {

}
