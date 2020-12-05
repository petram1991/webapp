package org.example.dao;

import org.example.domain.User;
import org.example.util.PasswordUtils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public void authenticate(String username, String password) {
        TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_USERNAME_PASSWORD, User.class);
        query.setParameter("username", username);
        query.setParameter("password", PasswordUtils.digestPassword(password));
        User user = query.getSingleResult();

        if (user == null) throw new SecurityException("Invalid user/password");
    }

    public void create(User user) {
        em.persist(user);
    }

    public List getAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }



}
