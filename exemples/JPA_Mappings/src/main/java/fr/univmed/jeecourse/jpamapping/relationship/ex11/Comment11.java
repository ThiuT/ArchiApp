package fr.univmed.jeecourse.jpamapping.relationship.ex11;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "relationship_ex10_comment")
public class Comment11 implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
@Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String content;
    private Integer note;
    
    // ======================================
    // =             Constants              =
    // ======================================

    // ======================================
    // =            Constructors            =
    // ======================================

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    // ======================================
    // =           Public Methods           =
    // ======================================

    // ======================================
    // =         Protected Methods          =
    // ======================================

    // ======================================
    // =          Private Methods           =
    // ======================================

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    // ======================================
    // =         hash, equals, toString     =
    // ======================================
}