package auction.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    public String getEmail() {
        return email;
    }

    @Id
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    @JoinColumn(name = "SELLER_ID")
    private Set<Item> offeredItems;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }


}

