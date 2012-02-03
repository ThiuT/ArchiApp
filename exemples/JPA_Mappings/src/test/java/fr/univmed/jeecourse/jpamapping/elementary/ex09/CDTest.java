package fr.univmed.jeecourse.jpamapping.elementary.ex09;

import fr.univmed.jeecourse.jpamapping.AbstractPersistentTest;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Book
 */
public class CDTest extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void createCD() throws Exception {

        HashMap<Integer, String> tracks = new HashMap<Integer, String>();
        tracks.put(1, "Wind Up Workin' in a Gas Station");
        tracks.put(2, "Black Napkins");
        tracks.put(3, "The Torture Never Stops");
        CD cd = new CD("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album", tracks);
        tx.begin();
        em.persist(cd);
        tx.commit();
        assertNotNull("ID should not be null", cd.getId());
//        assertEquals(3, cd.getTracks().size()); TODO
    }
}