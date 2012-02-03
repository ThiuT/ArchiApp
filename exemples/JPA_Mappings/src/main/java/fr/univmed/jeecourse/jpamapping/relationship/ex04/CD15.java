package fr.univmed.jeecourse.jpamapping.relationship.ex04;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "relationship_ex04_cd")
public class CD15 implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Float price;
    private String description;
    @ManyToMany(mappedBy = "appearsOnCDs")
    private List<Artist15> createdByArtists;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CD15() {
    }

    public CD15(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

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

    public List<Artist15> getCreatedByArtists() {
        return createdByArtists;
    }

    public void setCreatedByArtists(List<Artist15> createdByArtists) {
        this.createdByArtists = createdByArtists;
    }

    public void createdBy(Artist15 artist) {
        if (createdByArtists == null)
            createdByArtists = new ArrayList<Artist15>();
        createdByArtists.add(artist);
    }
}