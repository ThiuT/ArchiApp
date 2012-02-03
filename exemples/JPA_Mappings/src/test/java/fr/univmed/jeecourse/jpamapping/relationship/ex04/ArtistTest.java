package fr.univmed.jeecourse.jpamapping.relationship.ex04;

import fr.univmed.jeecourse.jpamapping.AbstractPersistentTest;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Customer
 */
public class ArtistTest extends AbstractPersistentTest {

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void createOrder() throws Exception {

        Artist15 ringo = new Artist15("Ringo", "Starr");
        Artist15 john = new Artist15("John", "Lenon");
        Artist15 franck = new Artist15("Franck", "Zappa");
        Artist15 jimi = new Artist15("Jimi", "Hendrix");

        CD15 zoot = new CD15("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album");
        CD15 sgtpepper = new CD15("Sergent Pepper", 28.5F, "Best Beatles Album");
        CD15 heyjoe = new CD15("Hey Joe", 32F, "Hendrix live with friends");

        ringo.appearsOn(sgtpepper);
        john.appearsOn(sgtpepper);
        john.appearsOn(heyjoe);
        franck.appearsOn(zoot);
        franck.appearsOn(heyjoe);
        jimi.appearsOn(heyjoe);
        jimi.appearsOn(sgtpepper);

        zoot.createdBy(franck);
        sgtpepper.createdBy(ringo);
        sgtpepper.createdBy(john);
        heyjoe.createdBy(jimi);

        tx.begin();
        em.persist(ringo);
        em.persist(john);
        em.persist(franck);
        em.persist(jimi);
        em.persist(zoot);
        em.persist(sgtpepper);
        em.persist(heyjoe);
        tx.commit();
        assertNotNull("Ringo ID should not be null", ringo.getId());
        assertNotNull("John ID should not be null", john.getId());
        assertNotNull("Franck ID should not be null", franck.getId());
        assertNotNull("Zoot ID should not be null", zoot.getId());
        assertNotNull("Sgt Pepper ID should not be null", sgtpepper.getId());
        assertNotNull("Hey Joe ID should not be null", heyjoe.getId());
    }
}