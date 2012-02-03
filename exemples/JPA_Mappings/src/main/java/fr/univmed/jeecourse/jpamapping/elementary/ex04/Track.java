package fr.univmed.jeecourse.jpamapping.elementary.ex04;
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
@Table(name = "elementary_ex04_track")
public class Track implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Float duration;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] wav;
    private String description;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Track() {
    }

    public Track(String title, Float duration, String description) {
        this.title = title;
        this.duration = duration;
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

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public byte[] getWav() {
        return wav;
    }

    public void setWav(byte[] wav) {
        this.wav = wav;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
