import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import static org.junit.Assert.*;

public class BcryptTest {
    @Test
    public void Bcrypttest() {
        String BasePass = "I4mTh3Password";
        String HashedPass = BCrypt.hashpw(BasePass, BCrypt.gensalt(12));

        assertTrue(BCrypt.checkpw(BasePass,HashedPass));
        assertFalse(BCrypt.checkpw("An0th3rP4ssW0rd",HashedPass));
    }
}
