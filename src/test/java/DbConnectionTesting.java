import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.auca.ac.rw.util.HibernateUtil;

public class DbConnectionTesting {

    private Session session;

    @Before
    public void setUp() {
        session = HibernateUtil.openSession();
    }

    @Test
    public void testingConnection() {
        assertNotNull("Session should be connected", session);
    }

    @After
    public void tearDown() {
        if (session != null) {
            session.close();
        }
    }
}