package fr.univmed.jeecourse.jpamapping.relationship.ex05;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "relationship_ex06_country")
public class Country16 implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private String isoCode;
    private String country;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Country16() {
    }

    public Country16(String isoCode, String country) {
        this.isoCode = isoCode;
        this.country = country;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
