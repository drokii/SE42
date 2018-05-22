package auction.domain;

<<<<<<< HEAD
import javax.persistence.Column;
=======
>>>>>>> c36485ce9e90321e1569a68fda7fc5624d096f84
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