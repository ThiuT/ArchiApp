package fr.univmed.jeecourse.jpamapping.inheritance.ex04;
import java.io.Serializable;
import javax.persistence.*;
/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "inheritance_ex04_cd")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "cd_id")),
        @AttributeOverride(name = "title", column = @Column(name = "cd_title")),
        @AttributeOverride(name = "description", column = @Column(name = "cd_description"))
})
public class CD04 extends Item04 implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    private String musicCompany;
    private Integer numberOfCDs;
    private Float totalDuration;
    private String gender;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CD04() {
    }

    public CD04(String title, Float price, String description, String musicCompany, Integer numberOfCDs, Float totalDuration, String gender) {
        super(title, price, description);
        this.musicCompany = musicCompany;
        this.numberOfCDs = numberOfCDs;
        this.totalDuration = totalDuration;
        this.gender = gender;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Integer getNumberOfCDs() {
        return numberOfCDs;
    }

    public void setNumberOfCDs(Integer numberOfCDs) {
        this.numberOfCDs = numberOfCDs;
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}