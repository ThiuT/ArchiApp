package fr.univmed.jeecourse.jpamapping.inheritance.ex07;
import javax.persistence.*;
/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Item07 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    protected Long id;
    @Column(length = 50, nullable = false)
    protected String title;
    protected Float price;
    @Column(length = 2000)
    protected String description;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Item07() {
    }

    public Item07(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}