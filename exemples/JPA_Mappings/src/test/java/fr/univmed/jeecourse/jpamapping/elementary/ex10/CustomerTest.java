package fr.univmed.jeecourse.jpamapping.elementary.ex10;

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
public class CustomerTest extends AbstractPersistentTest{

    // ======================================
    // =              Unit tests            =
    // ======================================
    @Test
    public void createCustomer() throws Exception {

        CustomerAccess customer = new CustomerAccess("John", "Smith", "jsmith@gmail.com", "1234565");
        tx.begin();
        em.persist(customer);
        tx.commit();
        assertNotNull("ID should not be null", customer.getId());
    }
}