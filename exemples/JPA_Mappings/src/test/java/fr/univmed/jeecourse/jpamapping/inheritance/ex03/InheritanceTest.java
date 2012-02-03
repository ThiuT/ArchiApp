package fr.univmed.jeecourse.jpamapping.inheritance.ex03;

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

        Item03 item01 = new Item03("Junk", 52.50f, "A piece of junk");
        CD03 cd01 = new CD03("St Pepper", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop/Rock");
        CD03 cd02 = new CD03("Love SUpreme", 20f, "John Coltrane love moment", "Blue Note", 2, 87.45f, "Jazz");
        Book03 book01 = new Book03("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
        Book03 book02 = new Book03("The Robots of Dawn", 37.5f, "Robots, again and again", "0-553-29949-2 ", "Foundation", 264, true);
        tx.begin();
        em.persist(item01);
        em.persist(cd01);
        em.persist(cd02);
        em.persist(book01);
        em.persist(book02);
        tx.commit();
        assertNotNull("Item ID should not be null", item01.getId());
        assertNotNull("CD1 ID should not be null", cd01.getId());
        assertNotNull("CD2 ID should not be null", cd02.getId());
        assertNotNull("Book1 ID should not be null", book01.getId());
        assertNotNull("Book2 ID should not be null", book02.getId());
    }
}