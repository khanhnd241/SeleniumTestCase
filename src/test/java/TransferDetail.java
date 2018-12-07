
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import edu.log.LogFactory;

public class TransferDetail {
	private static final Logger logger = LogFactory.getLogger();
	public void testTransferDetail(WebDriver driver, WebDriverWait wait) throws InterruptedException {
//		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"sidebar_main\"]/div/div[1]/div[2]/ul/li[2]/a"))));
		WebElement elementOperation = driver.findElement(By.xpath("//*[@id=\"sidebar_main\"]/div/div[1]/div[2]/ul/li[2]/a"));
		elementOperation.click();
		WebElement elementTransfer = driver.findElement(By.xpath("//*[@id=\"sidebar_main\"]/div/div[1]/div[2]/ul/li[2]/ul/li[1]/a"));
		elementTransfer.click();
		new WebDriverWait(driver, 20).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("transfers");
			}
		});
		assertEquals("Transfers", driver.getTitle());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"filterRow\"]/td[2]/input"))));
		WebElement elementSelectType = driver.findElement(By.xpath("//*[@id=\"filterRow\"]/td[2]/input"));
		elementSelectType.click();
		elementSelectType.sendKeys("INT");
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.partialLinkText("INT"))));
		List<WebElement> elementClickToSelect = driver.findElements((By.partialLinkText("INT")));
		elementClickToSelect.get(0).click();
		
		new WebDriverWait(driver, 20).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d2) {
				return d2.getTitle().toLowerCase().startsWith("transfer detail");
			}
		});
		// check select a transfer
		assertEquals("Transfer Detail", driver.getTitle());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[1]/div[1]"))));
		//check operation type
		WebElement operationType = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[1]/div[1]"));
		assertEquals("Operation Type", operationType.getText());
		
		//check partner
		WebElement partner = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[1]/div[2]"));
		assertEquals("Partner", partner.getText());
		
		//check Source Location
		WebElement sourceLocation = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[1]/div[3]"));
		assertEquals("Source Location", sourceLocation.getText());
		
		//check Destination Location
		WebElement destinationLocation = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[1]/div[4]"));
		assertEquals("Destination Location", destinationLocation.getText());
		
		//check Project
		WebElement project = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[1]/div[7]"));
		assertEquals("Project", project.getText());
		
		//check owner
		WebElement owner = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[3]/div[1]"));
		assertEquals("Owner", owner.getText());
		
		//check Schedule Date
		WebElement scheduleDate = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[3]/div[2]"));
		assertEquals("Schedule Date", scheduleDate.getText());
		
		//check Source Document
		WebElement sourceDocument = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[3]/div[3]"));
		assertEquals("Source Document", sourceDocument.getText());
		
		//check Assignee
		WebElement assignee = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[3]/div[4]"));
		assertEquals("Assignee", assignee.getText());
		
		//check SC BoM
		WebElement sCBoM = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[3]/div[7]"));
		assertEquals("SC BoM", sCBoM.getText());
		
		//check PO
		WebElement pO = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[3]/div[8]"));
		assertEquals("PO", pO.getText());
		
		//check internal transfers
		WebElement typeTransfer = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[3]/div[2]/div/div[2]/div[1]/a"));
		logger.info(typeTransfer.getText());
		String[] wordTransfer = typeTransfer.getText().split("\\s");
		logger.info(wordTransfer[wordTransfer.length-1]);
		//check transfer type is internal transfers
		assertEquals("Internal Transfers",wordTransfer[wordTransfer.length-2] + " " + wordTransfer[wordTransfer.length-1] );
		
		WebElement draft = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[1]/div[2]/div/a[2]"));
		assertEquals("DRAFT", draft.getText());
		
		WebElement waitingOther = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[1]/div[2]/div/a[4]"));
		assertEquals("WAITING OTHER", waitingOther.getText());
		
		WebElement waiting = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[1]/div[2]/div/a[6]"));
		assertEquals("WAITING", waiting.getText());
		
		WebElement ready = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[1]/div[2]/div/a[8]"));
		assertEquals("READY", ready.getText());
		
		WebElement done = driver.findElement(By.xpath("//*[@id=\"transfer_detail\"]/div/div[1]/div[2]/div/a[9]"));
		assertEquals("DONE", done.getText());
	}
}
