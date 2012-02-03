package fr.univmed.jeecourse.jpamapping.relationship.ex04;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "relationship_ex04_artist")
public class Artist15 implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "relationship_ex04_jnd_art_cd", joinColumns = @JoinColumn(name = "artist_fk"), inverseJoinColumns = @JoinColumn(name = "cd_fk"))
    private List<CD15> appearsOnCDs;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Artist15() {
    }

    public Artist15(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CD15> getAppearsOnCDs() {
        return appearsOnCDs;
    }

    public void setAppearsOnCDs(List<CD15> appearsOnCDs) {
        this.appearsOnCDs = appearsOnCDs;
    }

    public void appearsOn(CD15 cd) {
        if (appearsOnCDs == null)
            appearsOnCDs = new ArrayList<CD15>();
        appearsOnCDs.add(cd);
    }

}