package fr.univmed.jeecourse.jpamapping.elementary.ex02;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "elementary_ex02_news")
public class NewsEmbeddedId implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @EmbeddedId
    private NewsId id;
    private String content;

    // ======================================
    // =            Constructors            =
    // ======================================

    public NewsEmbeddedId() {
    }

    public NewsEmbeddedId(NewsId id, String content) {
        this.id = id;
        this.content = content;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public NewsId getId() {
        return id;
    }

    public void setId(NewsId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}