package org.example.dao;

import org.example.domain.Contact;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class ContactDaoDb {

    @PersistenceContext
    private EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }

    public Contact findById(Long id) {
        return em.find(Contact.class, id);
    }

    public void update(Contact c) {
        em.merge(c);
    }

    public void create(Contact c) {
        em.persist(c);
    }

    public void delete(Contact c) {
        if (!em.contains(c)) {
            c = em.merge(c);
        }

        em.remove(c);
    }
}
