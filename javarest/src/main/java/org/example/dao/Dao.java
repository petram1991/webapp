package org.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public abstract class Dao<T> {

    @PersistenceContext
    protected EntityManager em;

    public Collection<T> getAll() {
        return em.createNamedQuery(typeSimple() + ".findAll", T()).getResultList();
    }

    public T findById(Long id) {
        return em.find(T(), id);
    }

    public T update(T c) {
        em.merge(c);
        return c;
    }

    public T create(T c) {
        em.persist(c);
        return c;
    }

    public T delete(T c) {
        if (!em.contains(c)) {
            c = em.merge(c);
        }

        em.remove(c);
        return c;
    }

    private String typeSimple() { return T().getSimpleName(); }

    @SuppressWarnings("unchecked")
    private Class<T> T() {
        ParameterizedType thisDaoClass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) thisDaoClass.getActualTypeArguments()[0];
    }
}
