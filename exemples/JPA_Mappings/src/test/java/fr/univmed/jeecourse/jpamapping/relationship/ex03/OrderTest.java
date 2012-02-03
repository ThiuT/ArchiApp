package fr.univmed.jeecourse.jpamapping.relationship.ex03;

import static fr.univmed.jeecourse.jpamapping.Constants.PERSISTENCE_UNIT_NAME;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a Customer
 */
public class OrderTest {

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
    public void createOrder() throws Exception {

        Order14 order = new Order14();
        OrderLine14 ol1 = new OrderLine14("H2G2", 12d, 1);
        OrderLine14 ol2 = new OrderLine14("The White Album", 14.5d, 2);
        List<OrderLine14> orderLines = new ArrayList<OrderLine14>();
        orderLines.add(ol1);
        orderLines.add(ol2);
        order.setOrderLines(orderLines);
        tx.begin();
        em.persist(order);
        em.persist(ol1);
        em.persist(ol2);
        tx.commit();
        assertNotNull("Order ID should not be null", order.getId());
        assertNotNull("OL1 ID should not be null", ol1.getId());
        assertNotNull("OL1 ID should not be null", ol2.getId());

        order = em.find(Order14.class, order.getId());
        assertNotNull("OrderLines should not be null", order.getOrderLines());
        assertEquals("Should have 2 order lines", order.getOrderLines().size(), 2);
    }
}