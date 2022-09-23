package whatsappMultiplyMessage;

import java.time.Duration;
import org.openqa.selenium.By;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		String search = "Farlin New";
		String message = "the";
		int numOfTimes = 200;
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://web.whatsapp.com");
		
		WebElement searchBox = new WebDriverWait(driver, Duration.ofSeconds(30))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@contenteditable='true']")));
		
		searchBox.sendKeys(search);
		
		driver.findElement(By.xpath("//span[@title='"+search+"']")).click();
		
		for(int i = 0;i<numOfTimes;i++) {
			
			driver.findElement(By.xpath("//div[@id='main']//footer//div//div//div//div[@contenteditable='true']")).sendKeys(message);
			
			WebElement sendButton = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='send']")));
			
			sendButton.click();
			
		}
		
		
		
	}

}
