package scenarios;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Scenario4 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver,10);
		driver.manage().window().maximize();
		
		driver.get("https://www.myntra.com/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@data-reactid='19']"))).build().perform();
		
		driver.findElement(By.linkText("Sports Shoes")).click();
		a.moveToElement(driver.findElement(By.className("sort-sortBy"))).build().perform();
		
		driver.findElement(By.xpath("//label[normalize-space()=\"What's New\"]")).click();
		a.moveToElement(driver.findElement(By.className("desktop-searchBar"))).build().perform();
		w.until(ExpectedConditions.textToBe(By.xpath("//div[@class='sort-sortBy']/span"),"What'S New"));
		driver.findElement(By.xpath("//div[@class='vertical-filters-filters brand-container']//li[1]//label[1]//div[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("filter-summary-filter")));
		driver.findElement(By.xpath("//div[4]//ul[1]//li[1]//label[1]//div[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("filter-summary-colourBox")));
		driver.findElement(By.xpath("//div[@class='search-rightContainer column-base']//li[1]//a[1]")).click();
		Set<String>windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		driver.findElement(By.xpath("//div[7]//div[1]//button[1]")).click();
		driver.findElement(By.className("pdp-add-to-bag")).click();
		driver.findElement(By.className("desktop-iconBag")).click();
		driver.findElement(By.className("itemContainer-base-selectionIndicator")).click();
		driver.findElement(By.className("bulkActionStrip-desktopBulkWishlist")).click();
		driver.findElement(By.cssSelector(".inlinebuttonV2-base-actionButton.bulkActionStrip-waterMelon")).click();
		driver.quit();
	}

}
