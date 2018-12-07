import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.log.LogFactory;

public class Login {
	private static final Logger logger = LogFactory.getLogger();
	public void testLogin(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("email"))));
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		//user = admin
		email.sendKeys("admin");
		
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		// password = ssdc@vnpt
		password.sendKeys("ssdc@vnpt");
		// enter
		password.submit();
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("dashboard");
			}
		});
		logger.info("Login succeed");
		//check login passed
		assertEquals("Dashboard",driver.getTitle());
	}
}
