package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement findElement = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).perform();
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		String totalcount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total count of the items : " + totalcount);
		
		
		
	//	 String jackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]/text()[2]")).getText();
		//String rjackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]/text()[2]")).getText();		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class = 'common-checkboxIndicator']")).click();
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("duke");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class = ' common-customCheckbox']")).click();
		//driver.findElement(By.xpath("(//label[@class='vertical-filters-label common-customCheckbox'])[3]")).click();
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		List<WebElement> brandNames = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		for (WebElement webElement : brandNames) {
			if (webElement.getText().contains("Duke")) {
				
				System.out.println(" All the products belongs to Duke brand");
			} else {
				System.out.println(" All the products are not belonging to Duke brand");
			}break;
		}
		
		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(findElement2).perform();
		
		driver.findElement(By.xpath("//label[text() = 'Better Discount']")).click();
		
		//driver.findElement(By.xpath("//label[@class='sort-label sort-selected']")).click();
		
		String text = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("Price of the 1st product : "+text);
		
		driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(windowHandles);
		driver.switchTo().window(ls.get(1));
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/myntra.png");
		FileUtils.copyFile(screenshotAs, dst);
		
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.quit();
		
	}

}
