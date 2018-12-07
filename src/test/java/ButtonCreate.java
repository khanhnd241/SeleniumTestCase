import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.log.LogFactory;

public class ButtonCreate {
	private static final Logger logger = LogFactory.getLogger();


	public void testButtonCreate(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"sidebar_main\"]/div/div[1]/div[2]/ul/li[2]/a"))));
		WebElement elementOperation = driver.findElement(By.xpath("//*[@id=\"sidebar_main\"]/div/div[1]/div[2]/ul/li[2]/a"));
		elementOperation.click();
		WebElement elementTransfer = driver.findElement(By.xpath("//*[@id=\"sidebar_main\"]/div/div[1]/div[2]/ul/li[2]/ul/li[1]/a"));
		elementTransfer.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CREATE")));
		WebElement elementCreate = driver.findElement(By.linkText("CREATE"));
		assertEquals("CREATE", elementCreate.getText());
		//kiem tra co nut create tren giao dien cua danh sach giao dich
		assertTrue(elementCreate.isDisplayed());
		logger.info(elementCreate.isDisplayed());
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//click button create
		elementCreate.click();
		new WebDriverWait(driver, 20).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d2) {
				return d2.getTitle().toLowerCase().startsWith("new transfer");
			}
		});
		assertEquals("New Transfer", driver.getTitle());

		boolean present1;
		try {
		   driver.findElement(By.linkText("CREATE"));
		   present1 = true;
		} catch (NoSuchElementException e) {
		   present1 = false;
		   logger.info("Create button doesn't exists");
		}
		assertFalse(present1);
		logger.info("click to back transfer");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page_heading\"]/span/span[2]/a")));
		WebElement clickToBackTransfer = driver.findElement(By.xpath("//*[@id=\"page_heading\"]/span/span[2]/a"));
		//back to transfer detail
		clickToBackTransfer.click();
		logger.info("back to transfer detail");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"filterRow\"]/td[2]/input"))));
//		driver.findElement(By.xpath("//*[@id=\"filterRow\"]/td[11]/span/span/span[2]")).click();
		Select select = new Select(driver.findElement( By.id("activeFilter")));
		logger.info(select.getOptions().size());
		logger.info(select.getOptions().get(0).toString());
//		driver.findElement(By.xpath("//*[@id=\"filterRow\"]/td[11]/span/span/span[2]")).click();
//		Thread.sleep(3000);
//		select.selectByVisibleText("Ready");
//		select.selectBsyValue("Ready");
		select.getOptions().get(0);
//		logger.info(select.getAllSelectedOptions());
		
		
		
		WebElement elementSelectType = driver.findElement(By.xpath("//*[@id=\"filterRow\"]/td[2]/input"));
		elementSelectType.click();
		elementSelectType.sendKeys("INT");
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.partialLinkText("INT"))));
		WebElement elementClickToSelect = driver.findElement((By.partialLinkText("INT")));
		elementClickToSelect.click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#buttonEditTransfer > span"))));
		WebElement editButton = driver.findElement(By.cssSelector("#buttonEditTransfer > span"));
		editButton.click();
		boolean present2;
		try {
		   driver.findElement(By.linkText("CREATE"));
		   present2 = true;
		} catch (NoSuchElementException e) {
		   present2 = false;
		   logger.info("Create button doesn't exists");
		}
		assertFalse(present2);
	}
		
}
