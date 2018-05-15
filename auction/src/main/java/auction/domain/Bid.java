package auction.domain;

import nl.fontys.util.FontysTime;
import nl.fontys.util.Money;

import java.io.Serializable;

public class Bid implements Serializable {

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
