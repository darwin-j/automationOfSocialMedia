package sendingDiifMsgs;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		String reciverName = "Dino Abilash Whats";
		
		List<String> messages = Arrays.asList("All our dreams can come true, if we have the courage to pursue them.","The secret of getting ahead is getting started.","I’ve missed more than 9,000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life and that is why I succeed.","Don’t limit yourself. Many people limit themselves to what they think they can do. You can go as far as your mind lets you. What you believe, remember, you can achieve.","The best time to plant a tree was 20 years ago. The second best time is now.","Only the paranoid survive.","It’s hard to beat a person who never gives up.","I wake up every morning and think to myself, ‘how far can I push this company in the next 24 hours.","If people are doubting how far you can go, go so far that you can’t hear them anymore.","1We need to accept that we won’t always make the right decisions, that we’ll screw up royally sometimes – understanding that failure is not the opposite of success, it’s part of success.");
		
		ArrayList<String> messagesToShuffle = new ArrayList<String>();
		
		messagesToShuffle.addAll(messages);
	
		int numOfTimes = 1000;
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://web.whatsapp.com");
		
		WebElement searchBox = new WebDriverWait(driver, Duration.ofSeconds(30))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@contenteditable='true']")));
		
		searchBox.sendKeys(reciverName);
		
		driver.findElement(By.xpath("//span[@title='"+reciverName+"']")).click();
		
		for(int i = 0;i<numOfTimes;i++) {
			
			Collections.shuffle(messages);
			
			for(int j = 0;j<messages.size();j++) {
				driver.findElement(By.xpath("//div[@id='main']//footer//div//div//div//div[@contenteditable='true']")).sendKeys(messages.get(j));
				
				WebElement sendButton = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='send']")));
				
				sendButton.click();
			}
			
			
			
		}
	}

}
