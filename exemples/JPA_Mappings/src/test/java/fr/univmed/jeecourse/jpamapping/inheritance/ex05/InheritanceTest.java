package fr.univmed.jeecourse.jpamapping.inheritance.ex05;

import fr.univmed.jeecourse.jpamapping.AbstractPersistentTest;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class InheritanceTest extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void createItems() throws Exception {

        Book05 book01 = new Book05("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
        tx.begin();
        em.persist(book01);
        tx.commit();
        assertNotNull("Book1 ID should not be null", book01.getId());
    }
}