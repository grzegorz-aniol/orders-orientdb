package com.epam.plktw.repos;

import com.epam.plktw.InspectObj;
import io.codearte.jfairy.Fairy;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import java.time.LocalDate;
import java.util.function.Supplier;

import javax.annotation.PostConstruct;

public abstract class RepositoryTestsBase<E, R extends OrientObjectRepository<E>> {

    @Autowired
    protected R repo;
    
    @Autowired
    protected OrientObjectDatabaseFactory factory;
    
    protected EnhancedRandom random;

    protected InspectObj<E> inspect;

    protected Fairy fairy;

    protected RepositoryTestsBase() {
        
        fairy = Fairy.create();
        
        Supplier<String> namesSupplier = () -> { return fairy.textProducer().latinWord(3); };
        
        random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
                .minCollectionSize(1)
                .maxCollectionSize(10)
                .minStringLength(5)
                .maxStringLength(25)
                .maxObjectPoolSize(100)
                .maxRandomizationDepth(3)
                .dateRange(LocalDate.of(2000, 1, 1), LocalDate.now())
                .randomize(String.class, namesSupplier)
                .build();        
    }
        
    @PostConstruct
    protected void init() {
        inspect = new InspectObj<>(factory.db());        
    }
}
