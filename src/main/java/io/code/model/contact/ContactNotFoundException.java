package io.code.model.contact;

public class ContactNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ContactNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
