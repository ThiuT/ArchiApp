package fr.univmed.jeecourse.jpamapping.relationship.ex05;
import java.io.Serializable;
import javax.persistence.*;
/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Address entity is mapped to different tables
 */
@Entity
@Table(name = "relationship_ex05_address")
public class Address16 implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String street1;
    private String street2;
    private String city;
    @Column(name="ADDRESS_STATE")
    private String state;
    private String zipcode;
    @OneToOne
    private Country16 country;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Address16() {
    }

    public Address16(String street1, String street2, String city, String state, String zipcode, Country16 country) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Country16 getCountry() {
        return country;
    }

    public void setCountry(Country16 country) {
        this.country = country;
    }
}