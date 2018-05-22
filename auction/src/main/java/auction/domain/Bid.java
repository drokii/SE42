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
<<<<<<< HEAD
=======
import javax.persistence.*;

>>>>>>> c36485ce9e90321e1569a68fda7fc5624d096f84
@Entity
public class Bid {
=======
import java.io.Serializable;

public class Bid implements Serializable {
>>>>>>> parent of f12b1e9... Finished for week 12, need help doe

    private FontysTime time;
    private User buyer;
    private Money amount;

    public Bid(Item item, User buyer, Money amount) {
        //TODO
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