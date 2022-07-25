package io.code.crm.core.model.contact;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class ContactDao {

	@PersistenceContext
    EntityManager em;

    // constructor

    public List<Contact> findContacts(String name, String surname) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);

        Root<Contact> root = cq.from(Contact.class);
        Predicate cName = cb.like(root.get(Contact_.FIRST_NAME), name + "%");
        Predicate cSurname = cb.like(root.get(Contact_.SURNAME1), surname + "%");
        cq.where(cName, cSurname);

        TypedQuery<Contact> query = em.createQuery(cq);
        return query.getResultList();
    }

}