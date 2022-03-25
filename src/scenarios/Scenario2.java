package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scenario2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.yahoo.com/");
		String header = driver.findElement(By.xpath("//h4[text()='Trending Now']")).getText();
		Assert.assertTrue(header.equalsIgnoreCase("Trending Now"));
		WebElement trending = driver.findElement(By.xpath("//li[@class='spl d-ib w-100p']"));
		List<WebElement>links = trending.findElements(By.tagName("a"));
	    for(int i=0;i<links.size();i++)
		{
			
			System.out.println(links.get(i).getText());
			links.get(i).click();
			driver.navigate().back();
			trending = driver.findElement(By.xpath("//li[@class='spl d-ib w-100p']"));
			links = trending.findElements(By.tagName("a"));
	
            
		}
	    
	    driver.findElement(By.cssSelector("a[aria-label='COVID-19 Updates']")).click();
	    List<WebElement> table = driver.findElements(By.xpath("//table[contains(@class,'mt-4 bt-1 bl-1-E2E2E6 br-1-E2E2E6')]"));
	    driver.close();

	}

}
