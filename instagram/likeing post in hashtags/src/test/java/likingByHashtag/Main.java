package likingByHashtag;


import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		 
		String userName = "someone_calls_me_wolf";
		String password = "werewolf46";
		
		String rawHashtags = "#cat";
		int likes = 20;
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		String[] hashArr = rawHashtags.split(" ");
		ArrayList<String> hashtagsForLikeing = new ArrayList<String>();
		
		
		for(int i = 0 ;i<hashArr.length;i++) {
			
			hashtagsForLikeing.add(hashArr[i]);
		}
	
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
	    
	    
	    for(String hashtag:hashtagsForLikeing) {
	    	driver.findElement(By.xpath("//div[@id='react-root']//section//nav//div//div//div//div//div[@role='button']")).click();
		    
		    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(hashtag);
		    
		    WebElement searchClick = new WebDriverWait(driver, Duration.ofSeconds(30))
			        .until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='react-root']/section/nav/div/div/div/div/div/div[@aria-hidden='false']/div/div/div[1]/a[1]/div[1]")));
		    
		    searchClick.click();
		    
		    Actions actions = new Actions(driver);
		    
		    
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		  
		    
		    WebElement pageHeading = new WebDriverWait(driver, Duration.ofSeconds(30))
			        .until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='"+hashtag+"']")));
		    
		    if(driver.findElements(By.xpath("//h1[normalize-space()='"+hashtag+"']")).size() != 0  ) {
		    	
		    	 WebElement firstPost = new WebDriverWait(driver, Duration.ofSeconds(30))
					        .until(ExpectedConditions.elementToBeClickable(By.xpath("//body//div[@id='react-root']//div//div//div//div[1]//div[1]//a[1]//div[1]//div[2]")));
				                                                                     
				    
				    js.executeScript("arguments[0].scrollIntoView();", firstPost);  //scroll to the first post
				    
				    actions.moveToElement(firstPost).perform();//hover on first post
				    
				    
				    
				    WebElement comment = new WebDriverWait(driver, Duration.ofSeconds(20))
			  		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//main[@role='main']//article//div//div//div//div//div//a//div//ul//li")));
				  
				    
				    comment.click();
				    
				    for (int i = 0;i<likes;i++) {
				    	
				    	  WebElement likeButton = new WebDriverWait(driver, Duration.ofSeconds(120))
				  		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']//section//span[1]//button[1]")));
				  	    Thread.sleep(200);
				  	    likeButton.click();
				  	  driver.findElement(By.xpath("//span[@style='display: inline-block; transform: rotate(90deg);']")).click();
				  	
				  	    
				    }
				    
				    driver.findElement(By.xpath("//body/div[@role='dialog']/div/button[1]")).click();
				    
				    

				
		    	
		    }else {
		    	System.out.println("element not Found");
		    }
		    
		    
		   
	    };
	    
	   
	    
	    
	}

}
