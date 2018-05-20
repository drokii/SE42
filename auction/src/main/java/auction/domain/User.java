package auction.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    private String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
            Set<Item> offeredItems;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Item> getOfferedItems() {
        return offeredItems;
    }

    public void addItem(Item item) {
        offeredItems.add(item);
    }

    public int numberOfOfferedItems() {
        return offeredItems.size();
    }

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

}

