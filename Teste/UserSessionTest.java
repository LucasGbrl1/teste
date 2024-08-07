import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserSessionTest {
    private UserSession session;

    @Before
    public void setUp() {
        session = UserSession.getInstance();
    }

    @After
    public void tearDown() {
        session.setEmail(null); // Limpa o email após cada teste
    }

    @Test
    public void testSingletonInstance() {
        UserSession anotherSession = UserSession.getInstance();
        assertSame(session, anotherSession);
    }

    @Test
    public void testSetAndGetEmail() {
        String email = "test@example.com";
        session.setEmail(email);
        assertEquals(email, session.getEmail());
    }

    @Test
    public void testClearEmail() {
        session.setEmail("test@example.com");
        session.setEmail(null);
        assertNull(session.getEmail());
    }
}
