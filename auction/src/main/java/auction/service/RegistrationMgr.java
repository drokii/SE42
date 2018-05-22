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

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auctionPU");
    private EntityManager em;
    private UserDAO userDAO;

    public RegistrationMgr() {
    }

    public RegistrationMgr(EntityManager em) {
        this.em = em;
    }

    public User registerUser(String email) {
        em = emf.createEntityManager();
        userDAO = new JPAUserDAOCollectionImpl(this.em);
        this.em.getTransaction().begin();
        if (!email.contains("@")) {
            return null;
        }
        User user = userDAO.findByEmail(email);
        if (user != null) {
            return user;
        }
<<<<<<< HEAD
        user = new User(email);
        userDAO.create(user);
        this.em.getTransaction().commit();
        return user;
=======
        else{
            user = new User(email);
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            userDAO.create(user);
            em.getTransaction().commit();
            em.close();
            return user;
        }
>>>>>>> c36485ce9e90321e1569a68fda7fc5624d096f84
    }


    public User getUser(String email) {
        em = emf.createEntityManager();
        userDAO = new JPAUserDAOCollectionImpl(this.em);
        this.em.getTransaction().begin();
        User returner = userDAO.findByEmail(email);
        em.close();
        return returner;
    }

    public List<User> getUsers() {
        em = emf.createEntityManager();
        userDAO = new JPAUserDAOCollectionImpl(this.em);
        this.em.getTransaction().begin();
        List<User> returner = userDAO.findAll();
        em.close();
        return returner;
    }
}
