import static org.junit.Assert.*;
import org.junit.Test;
import com.auca.ac.rw.controller.ConnectionController;

public class DatabaseConnectionTest {

    @Test
    public void testConnection() {
        ConnectionController connection = new ConnectionController();
        String result = connection.establishConnection();
        assertEquals("connected", result);
    }
}