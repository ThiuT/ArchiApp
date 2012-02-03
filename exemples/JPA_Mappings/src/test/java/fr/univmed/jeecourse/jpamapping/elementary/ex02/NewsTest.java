package fr.univmed.jeecourse.jpamapping.elementary.ex02;

import static fr.univmed.jeecourse.jpamapping.Constants.PERSISTENCE_UNIT_NAME;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a News (using the EmbeddedId annotation)
 */
public class NewsTest {

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
    public void createNews() throws Exception {

        NewsEmbeddedId news = new NewsEmbeddedId(new NewsId("Richard Wright has died", "EN"), "The keyboard of Pink Floyd has died today");
        tx.begin();
        em.persist(news);
        tx.commit();

        news = em.find(NewsEmbeddedId.class, new NewsId("Richard Wright has died", "EN"));

        assertEquals("The keyboard of Pink Floyd has died today", news.getContent());
    }
}