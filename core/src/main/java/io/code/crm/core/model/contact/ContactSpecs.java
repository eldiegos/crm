package io.code.crm.core.model.contact;

import org.springframework.data.jpa.domain.Specification;

public class ContactSpecs {

	private ContactSpecs() {}
	
    public static Specification<Contact> hasFirstNameLike(String name) {
        return (root, query, criteriaBuilder) ->
          criteriaBuilder.like(root.<String>get(Contact_.FIRST_NAME), "%" + name + "%");
    }

    public static Specification<Contact> hasLastName(String name) {
        return (root, query, cb) ->
          cb.equal(root.<String>get(Contact_.SURNAME1), name);
    }
}