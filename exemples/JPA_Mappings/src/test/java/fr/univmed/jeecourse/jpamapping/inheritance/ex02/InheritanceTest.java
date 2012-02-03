package fr.univmed.jeecourse.jpamapping.inheritance.ex02;

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

        Item02 item01 = new Item02("Junk", 52.50f, "A piece of junk");
        CD02 cd01 = new CD02("St Pepper", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop/Rock");
        CD02 cd02 = new CD02("Love SUpreme", 20f, "John Coltrane love moment", "Blue Note", 2, 87.45f, "Jazz");
        Book02 book01 = new Book02("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
        Book02 book02 = new Book02("The Robots of Dawn", 37.5f, "Robots, again and again", "0-553-29949-2 ", "Foundation", 264, true);
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