package io.code.crm.core.model;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.extern.java.Log;


/*
 * Based on https://www.baeldung.com/database-auditing-jpa
 * 
 */

@Log
public class AuditListener {
    
    @PrePersist
    @PreUpdate
    @PreRemove
    private <T> void beforeAnyOperation(T entity) { 
    	
    	if(entity instanceof NamedEntity) {
    		log.fine("Hello " + ((NamedEntity) entity).getName());
    	}
    	else {
    		log.fine("Auditing " + ((BaseEntity) entity).getId().toString());
    	}
    }
    
}