package org.gangel.orientdb.repos;

import org.gangel.orientdb.model.Address;
import org.springframework.data.orient.object.repository.OrientObjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface AddressRepository extends OrientObjectRepository<Address> {

    public List<Address> findByStreetAndCityAndCountryAllIgnoreCase(String street, String city, String country);
    
    public Stream<Address> findByStreetAndCityAndCountryIgnoreCase(String street, String city, String country);
    
    
}
