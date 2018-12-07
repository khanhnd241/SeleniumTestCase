import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.log.LogFactory;

public class SetUp {
	private static final Logger logger = LogFactory.getLogger();
	
	public void setUp(WebDriver driver) {
		logger.info("Connecting...");
		driver.manage().window().maximize();
		driver.get("http://10.15.12.148:9090/#/login");	
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("login");
			}
		});		
		assertEquals("Login",driver.getTitle());
		logger.info("Connected!");
	}

	public SetUp() {
		System.setProperty("webdriver.gecko.driver","..\\geckodriver.exe");
		
	}
	
}
