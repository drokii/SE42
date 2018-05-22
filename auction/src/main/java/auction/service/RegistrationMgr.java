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
<<<<<<< HEAD
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
=======
        user = new User(email);
        userDAO.create(user);
        this.em.getTransaction().commit();
        this.em.clear();
        return user;
>>>>>>> parent of f12b1e9... Finished for week 12, need help doe
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
