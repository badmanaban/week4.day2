package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement findElement = driver.findElement(By.xpath("(//span[text()=\"Men's Fashion\"])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).perform();

		driver.findElement(By.xpath("(//span[text()=\"Sports Shoes\"])[1]")).click();
		String text = driver.findElement(By.xpath("(//span[@class=\"category-count\"])[1]")).getText();
		System.out.println("Count of sports shoes : " + text);
		driver.findElement(By.xpath("//div[text()=\"Training Shoes\"]")).click();

		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		Thread.sleep(3000);
		String item1 = driver.findElement(By.xpath("(//div[@class='lfloat marR10']/span[2])[1]"))
				.getAttribute("display-price");
		System.out.println("Item 1 price is : " + item1);
		String item2 = driver.findElement(By.xpath("(//div[@class='lfloat marR10']/span[2])[2]"))
				.getAttribute("display-price");
		System.out.println("Item 2 price is : " + item2);

		driver.findElement(By.xpath("((//div[@class='price-text-box'])/input)[1]")).clear();
		driver.findElement(By.xpath("((//div[@class='price-text-box'])/input)[1]")).sendKeys("900");

		driver.findElement(By.xpath("((//div[@class='price-text-box'])/input)[2]")).clear();
		driver.findElement(By.xpath("((//div[@class='price-text-box'])/input)[2]")).sendKeys("2500");

		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("//div[@class = 'product-tuple-image ']"));
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(findElement2).perform();
		//Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		String text2 = driver.findElement(By.xpath("//div[@class='lfloat']/div[2]//span[1]")).getText();
		System.out.println("Price is : " + text2);
		String text3 = driver.findElement(By.xpath("//div[@class='lfloat']/div[2]//span[2]")).getText();
		System.out.println("Discount is : " + text3);

		File sh = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snap/sh2.png");
		FileUtils.copyFile(sh, dst);
		driver.close();
		driver.quit();

	}

}
