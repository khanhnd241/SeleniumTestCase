import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.log.LogFactory;

public class Logout {
	private static final Logger logger = LogFactory.getLogger();
	public void testLogout(WebDriver driver, WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("user_action_image"))));
		WebElement elementLogout = driver.findElement(By.className("user_action_image"));		
		elementLogout.click();
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"header_main\"]/div[1]/nav/div[3]/ul/li[4]/div/ul/li[3]/a"));
		logout.click();
		logger.warn("Logout");
		new WebDriverWait(driver, 4).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("login");
			}
		});
		// check logout passed
		assertEquals("Login", driver.getTitle());	
	}
}
