package fr.univmed.jeecourse.ejbexample;

import javax.ejb.EJB;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private static BookEJBRemote bookEJB;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public static void main(String[] args) {

        // Creates an instance of book
        Book book = new Book();
        book.setTitle("The Hitchhiker's Guide to the Galaxy");
        book.setPrice(12.5F);
        book.setDescription("Science fiction comedy series created by Douglas Adams.");
        book.setIsbn("1-84023-742-2");
        book.setNbOfPage(354);
        book.setIllustrations(false);

        bookEJB.createBook(book);

        book.setTitle("H2G2");
        bookEJB.updateBook(book);
        
        bookEJB.deleteBook(book);
    }
}