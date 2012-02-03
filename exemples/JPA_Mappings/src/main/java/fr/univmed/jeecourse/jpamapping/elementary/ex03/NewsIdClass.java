package fr.univmed.jeecourse.jpamapping.elementary.ex03;


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
@Table(name = "elementary_ex03_news")
@IdClass(NewsId.class)
public class NewsIdClass implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    private String title;
    @Id
    @Column(name="NEWS_LANGUAGE")
    private String language;
    private String content;

    // ======================================
    // =            Constructors            =
    // ======================================

    public NewsIdClass() {
    }

    public NewsIdClass(String title, String language, String content) {
        this.title = title;
        this.language = language;
        this.content = content;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}