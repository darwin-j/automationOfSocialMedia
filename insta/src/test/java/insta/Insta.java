package insta;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Insta {

	public static void main(String[] args) {
		
		String userName = "lovit_zone";
		String password = "farlufarlu";
		String usernameOfLikeing = "_thamili_";
		int likes = 12;
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.instagram.com");
		
		WebElement userNameInput = new WebDriverWait(driver, Duration.ofSeconds(30))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Phone number, username, or email']")));
		userNameInput.sendKeys(userName);
		
		driver.findElement(By.xpath("//input[@aria-label='Password']")).sendKeys(password);
		
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    WebElement notnowButton1 = new WebDriverWait(driver, Duration.ofSeconds(30))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Not Now']")));
	    		
	    notnowButton1.click();
	    
	    
	    if(driver.findElements(By.xpath("//button[normalize-space()='Not Now']")).size() != 0) {
	    	 WebElement notnowButton2 = new WebDriverWait(driver, Duration.ofSeconds(30))
	 		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Not Now']")));
	 	    
	 	    notnowButton2.click();
	    }
	    
	    
	    driver.findElement(By.xpath("//div[@id='react-root']//section//nav//div//div//div//div//div[@role='button']")).click();
	    
	    
	    
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(usernameOfLikeing);
	    
	    WebElement searchClick = new WebDriverWait(driver, Duration.ofSeconds(30))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'"+usernameOfLikeing+"')]")));
	    
	    searchClick.click();
	    
	    Actions actions = new Actions(driver);
	    
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    
	    
	    WebElement post = new WebDriverWait(driver, Duration.ofSeconds(30))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//body//div[@id='react-root']//div//div//div//div//div[1]//div[1]//a[1]//div[1]//div[2]")));
	    
	    
	    js.executeScript("arguments[0].scrollIntoView();", post);  //scroll to the first post
	    
	    actions.moveToElement(post).perform();//hover on first post
	    
	    
	    WebElement heart = new WebDriverWait(driver, Duration.ofSeconds(10))
  		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='_1P1TY coreSpriteHeartSmall']")));
	  
	    
	    heart.click();
	    
	    for (int i = 0;i<likes;i++) {
	    	
	    	  WebElement likeButton = new WebDriverWait(driver, Duration.ofSeconds(30))
	  		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']//section//span[1]//button[1]")));
	  	    
	  	    likeButton.click();
	  	  driver.findElement(By.xpath("//a[normalize-space()='Next']")).click();
	  	    
	    }
	
	    
	    
	    
	    
	    
	    
	  
	  
	  
	   
	}

}
