//package bank4;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.revature.repositories.UserDAO;
//import com.revature.repositories.UserPostgresDAO;
//
//public class UserDAOTest {
//	private UserDAO ud;
//	
//	@BeforeEach
//	public void setupUserDAO() {
//		this.ud = new UserPostgresDAO();
//	}
//	
//	@Test
//	public void testFindUserByUserNameAndPassword() {
//		assertEquals("aaaa","pword", ud.findUserByUsernameAndPassword("aaaa", "pword"));
//		assertEquals("Cloud","mueramana3$2");
//		assertEquals("qwerty","qwertyuiop");
//	}
//	@Test
//	public void testviewBalance() {
//		assertEquals("")
//	}
//}
