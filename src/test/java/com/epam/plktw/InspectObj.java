package com.epam.plktw;

import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import java.util.Optional;
public class InspectObj<T> {
    
    private OObjectDatabaseTx db;
    
    public InspectObj(OObjectDatabaseTx db1) {
        this.db = db1;
    }

    public T print(T element) {
        if (element != null && db != null) {
            ODocument doc = db.getRecordByUserObject(element, false);
            if (doc != null) {
                System.out.println(doc.toString());
            }
        }
        return element; 
    }
    
    
    public Optional<T> printOptional(T element) {
        if (element != null && db != null) {
            ODocument doc = db.getRecordByUserObject(element, false);
            if (doc != null) {
                System.out.println(doc.toString());
            }
        }
        return Optional.ofNullable(element); 
    }    
    
    
    
}