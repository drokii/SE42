package auction.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Category {

    @Column(name = "CATEGORY_DESCRIPTION")
    private String description;

    private Category() {
        description = "undefined";
    }

    public Category(String description) {
        this.description = description;
    }

    public String getDiscription() {
        return description;
    }
}