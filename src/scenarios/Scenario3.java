package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Scenario3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.yahoo.com/");
		String header = driver.findElement(By.xpath("//ol/li/div/div/ul/li/div/h4")).getText();
		Assert.assertTrue(header.equalsIgnoreCase("Trending Now"));
		WebElement trending = driver.findElement(By.cssSelector(".spl.d-ib.w-100p"));
		List<WebElement>links = trending.findElements(By.tagName("a"));
	    for(int i=0;i<links.size();i++)
		{
			
			System.out.println(links.get(i).getText());
			links.get(i).click();
			driver.navigate().back();
			trending = driver.findElement(By.cssSelector(".spl:nth-child(1)"));
			links = trending.findElements(By.tagName("a"));
	
            
		}
	    
	    driver.findElement(By.linkText("COVID-19 Updates")).click();
	   List<WebElement> table = driver.findElements(By.xpath("//table[contains(@class,'mt-4 bt-1 bl-1-E2E2E6 br-1-E2E2E6')]"));
       driver.close();


	}

}
