package fr.univmed.jeecourse.ejbexample;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class BookEJB implements BookEJBRemote {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "samplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @Override
    public List<Book> findBooks() {
        Query query = em.createNamedQuery("findAllBooks");
        return query.getResultList();
    }

    @Override
    public Book findBookById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public void deleteBook(Book book) {
        em.remove(em.merge(book));
    }

    @Override
    public Book updateBook(Book book) {
        return em.merge(book);
    }
}