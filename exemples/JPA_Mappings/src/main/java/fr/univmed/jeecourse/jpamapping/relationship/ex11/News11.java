package fr.univmed.jeecourse.jpamapping.relationship.ex11;

import java.io.Serializable;
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
@Table(name = "relationship_ex10_news")
public class News11 implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String content;
    @OneToMany(fetch = FetchType.EAGER)
    //@OrderColumn("publication_index")  TODO
    private List<Comment11> comments;

    // ======================================
    // =            Constructors            =
    // ======================================

    public News11() {
    }

    public News11(String content) {
        this.content = content;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}