package auction.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

<<<<<<< HEAD
=======
import javax.persistence.*;

>>>>>>> c36485ce9e90321e1569a68fda7fc5624d096f84
@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Item item;
    @Embedded
    private FontysTime time;
    @ManyToOne
    private User buyer;
    @Embedded
    private Money amount;

    public Bid() {
    }

    public Bid(Item item, User buyer, Money amount) {
        this.item = item;
        this.buyer = buyer;
        this.amount = amount;
    }

    public FontysTime getTime() {
        return time;
    }

    public User getBuyer() {
        return buyer;
    }

    public Money getAmount() {
        return amount;
    }
}