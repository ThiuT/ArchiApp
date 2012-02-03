package fr.univmed.jeecourse.ejbexample;

import javax.ejb.Remote;
import javax.ejb.Local;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Remote
public interface BookEJBRemote {

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Book> findBooks();

    public Book findBookById(Long id);

    public Book createBook(Book book);

    public void deleteBook(Book book);

    public Book updateBook(Book book);
}