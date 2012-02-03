package fr.univmed.jeecourse.jpamapping.elementary.ex02;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Primary key of the news mapped as an Embeddable
 */
@Embeddable
public class NewsId implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    private String title;
    private String language;

    // ======================================
    // =            Constructors            =
    // ======================================

    public NewsId() {
    }

    public NewsId(String title, String language) {
        this.title = title;
        this.language = language;
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

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsId newsId = (NewsId) o;

        if (!language.equals(newsId.language)) return false;
        if (!title.equals(newsId.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}