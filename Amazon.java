package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the 1st result is : " + text);

		String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText();
		System.out.println("Total numbers of user rated : " + text2);

		driver.findElement(By.xpath("(//a[@role='button']/i)[2]")).click();
		//Actions builder = new Actions(driver);
		//builder.moveToElement(e1).perform();

		String text3 = driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[2]")).getText();
		System.out.println("percentage of ratings for the 5 star : " + text3);

		driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal']/span)[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> w = new ArrayList<String>(windowHandles);
		driver.switchTo().window(w.get(1));

		WebElement findElement = driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/img"));
		File sc = findElement.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/pic1.png");
		FileUtils.copyFile(sc, dst);

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(2000);
		String text4 = driver.findElement(By.xpath("//div[@class='a-column a-span11 a-text-left a-spacing-top-large']")).getText();
		if (text4.contains(text)) {
			System.out.println("Price is correct");
		} else {
			System.out.println("Incorrect price");
		}

	}

}
