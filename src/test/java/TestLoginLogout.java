
import static org.junit.Assert.assertEquals;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.log.LogFactory;


public class TestLoginLogout {
	private WebDriver driver;
	private static final Logger logger = LogFactory.getLogger();
	private WebDriverWait wait;
@Before
	public void install() {
	SetUp setUp = new SetUp();
	driver = new FirefoxDriver();
	wait = new WebDriverWait(driver, 20);
	setUp.setUp(driver);
}
@Test
	public void main() throws InterruptedException {
		//Test login
		Login login = new Login();
		login.testLogin(driver, wait);
		//Test transfer detail
//		TransferDetail transferDetail = new TransferDetail();
//		transferDetail.testTransferDetail(driver, wait);
		//test button create
		ButtonCreate testButtonCreate = new ButtonCreate();
		testButtonCreate.testButtonCreate(driver, wait);
		// Test logout
		Thread.sleep(5000);
		Logout logout = new Logout();
		logout.testLogout(driver, wait);		
	}
@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
}
