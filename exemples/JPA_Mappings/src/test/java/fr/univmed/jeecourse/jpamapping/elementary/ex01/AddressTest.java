package fr.univmed.jeecourse.jpamapping.elementary.ex01;

import static fr.univmed.jeecourse.jpamapping.Constants.PERSISTENCE_UNIT_NAME;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates an Address
 */
public class AddressTest {

    // ======================================
    // =             Attributes             =
    // ======================================
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================
    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void closeEntityManager() throws SQLException {
        em.close();
        emf.close();
    }

    @Before
    public void initTransaction() {
        tx = em.getTransaction();
    }

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void createAddress() throws Exception {

        Address address = new Address(getRandomId(), "65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
        tx.begin();
        em.persist(address);
        tx.commit();
        assertNotNull("ID should not be null", address.getId());
    }

    private Long getRandomId() {
        return new Double(Math.random()).longValue();
    }
}