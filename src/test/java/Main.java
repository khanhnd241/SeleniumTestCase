//import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import edu.log.LogFactory;
//
//public class Main {
//	private WebDriver driver;
//	private static final Logger logger = LogFactory.getLogger();
//	private WebDriverWait wait;
//@Before
//	public void install() {
//	SetUp setUp = new SetUp();
//	driver = new FirefoxDriver();
//	wait = new WebDriverWait(driver, 20);
//	setUp.setUp(driver);
//	}
//@Test
//	public void main() {
//		//Test login
//		Login login = new Login();
//		login.testLogin(driver, wait);
//		// Test logout
//		Logout logout = new Logout();
//		logout.testLogout(driver, wait);
//	}
//@After
//	public void tearDown() throws Exception {
//		// Close the browser
//		driver.quit();
//	}
//}
