package io.code.crm.core.model;

public class EntityNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Class<?> entity, String errorMessage) {
        super(errorMessage);
    }

}
