package auction.service;

import auction.dao.ItemDAO;
import auction.dao.ItemDAOJPAImpl;
import nl.fontys.util.Money;
import auction.domain.Bid;
import auction.domain.Item;
import auction.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AuctionMgr  {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("auctionPU");
    private EntityManager em;
    private ItemDAO itemDAO;

    public AuctionMgr() {
    }

    public AuctionMgr(EntityManager em) {
        this.em = em;
        itemDAO = new ItemDAOJPAImpl(this.em);
    }

    public Item getItem(Long id) {
        em = emf.createEntityManager();
        itemDAO = new ItemDAOJPAImpl(this.em);
        this.em.getTransaction().begin();
        Item returner = itemDAO.find(id);
        em.getTransaction().commit();
        em.close();
        return returner;
    }

    public List<Item> findItemByDescription(String description) {
        em = emf.createEntityManager();
        itemDAO = new ItemDAOJPAImpl(this.em);
        this.em.getTransaction().begin();
        List<Item> returner = itemDAO.findByDescription(description);
        em.getTransaction().commit();
        em.close();
        return returner;
    }

    public Bid newBid(Item item, User buyer, Money amount) {
        em = emf.createEntityManager();
        itemDAO = new ItemDAOJPAImpl(this.em);
        this.em.getTransaction().begin();
        Bid returner = item.newBid(buyer, amount);
        itemDAO.edit(item);
        em.getTransaction().commit();
        em.close();
        return returner;
    }
}
