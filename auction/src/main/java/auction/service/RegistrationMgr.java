package auction.service;

import java.util.*;

import auction.dao.JPAUserDAOCollectionImpl;
import auction.domain.User;
import auction.dao.UserDAOCollectionImpl;
import auction.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistrationMgr {

    private UserDAO userDAO;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auctionPU");
    private EntityManager em;


    public RegistrationMgr(EntityManager em) {
       this.em = em;
       userDAO = new JPAUserDAOCollectionImpl(this.em);
    }

    public User registerUser(String email) {

        this.em.getTransaction().begin();
        if (!email.contains("@")) {
            return null;
        }
        User user = userDAO.findByEmail(email);
        if (user != null) {
            return user;
        }
        user = new User(email);
        userDAO.create(user);
        this.em.getTransaction().commit();
        this.em.clear();
        return user;
    }

    public User getUser(String email) {
        this.em.getTransaction().begin();
        User user = userDAO.findByEmail(email);
        this.em.clear();
        return user;
    }

    public List<User> getUsers() {
        this.em.getTransaction().begin();
        List<User> users = userDAO.findAll();
        em.clear();
        return users;
    }
}
