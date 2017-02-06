package org.gangel.orientdb;

import com.orientechnologies.orient.core.serialization.serializer.object.OObjectSerializer;
import com.orientechnologies.orient.object.serialization.OObjectSerializerContext;
import com.orientechnologies.orient.object.serialization.OObjectSerializerHelper;
import org.gangel.orientdb.repos.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orient.OrientAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.Jsr310Converters.DateToLocalDateConverter;
import org.springframework.data.convert.Jsr310Converters.LocalDateToDateConverter;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
@EnableOrientRepositories(basePackageClasses=AddressRepository.class)
@EntityScan(basePackageClasses={org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.class})
public class DbConfiguration extends OrientAutoConfiguration {

    @Autowired
    private OrientObjectDatabaseFactory factory;
    
    public static class LocalDateSerializer implements OObjectSerializer<LocalDate, Date> {
        
        public Date serializeFieldValue(Class<?> itype,  LocalDate iFieldValue) {
            return LocalDateToDateConverter.INSTANCE.convert(iFieldValue);
          }

          public LocalDate unserializeFieldValue(Class<?> itype,  Date iFieldValue) {
            return DateToLocalDateConverter.INSTANCE.convert(iFieldValue);
          }        
    };

    
    @PostConstruct
    @Transactional
    public void registerEntities() {
        OObjectSerializerContext serializerContext = new OObjectSerializerContext();
        serializerContext.bind(new LocalDateSerializer(), factory.db());
        OObjectSerializerHelper.bindSerializerContext(null, serializerContext);
        
        factory.db().getEntityManager().registerEntityClasses("org.gangel.orientdb.model");
    }    
    
}
